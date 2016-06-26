package com.karson.portfolio.adnfeed.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.karson.portfolio.adnfeed.Constants;
import com.karson.portfolio.adnfeed.Util;
import com.karson.portfolio.adnfeed.model.AppNetData;
import com.karson.portfolio.adnfeed.model.AppNetRowData;
import com.karson.portfolio.adnfeed.model.Datum;
import com.karson.portfolio.adnfeed.model.Meta;
import com.karson.portfolio.adnfeed.rest.AppNetRestService;
import com.karson.portfolio.adnfeed.rest.RestServiceFactory;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by smuthuvijayan on 6/24/16.
 */

public class AppNetService extends Service {

    public static String TAG = AppNetService.class.getSimpleName();

    private final IBinder mBinder = new AppNetServiceBinder();

    private final AppNetRestService appNetService = RestServiceFactory.createRetrofitService(AppNetRestService.class,
                                                            AppNetRestService.APP_NET_SERVICE_ENDPOINT);

    private Meta meta;

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private volatile ScheduledFuture<?> future;

    public class AppNetServiceBinder extends Binder {
        public AppNetService getService() {
            return AppNetService.this;
        }
    }

    Runnable appNetRowDataSendRunnable = () ->
            convertToAppNetRowData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<AppNetRowData>>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "Data get completed");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "Data get error", e);
                        }

                        @Override
                        public void onNext(List<AppNetRowData> appNetRowDataList) {
                            Log.d(TAG, "Num rows to write to bus = " + appNetRowDataList.size());
                            EventBus.getDefault().post(appNetRowDataList);
                        }
                    });

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called");
        meta = new Meta();
        meta.setMaxId(Util.getFromSharedPref(getApplicationContext(),
                Constants.LAST_POST_MESSAGE_SHARED_PREF_KEY));
        Log.d(TAG, "lastPostID from shared pref = " + meta.getMaxId());
        future = scheduler.scheduleAtFixedRate(appNetRowDataSendRunnable, 0,
                                            Constants.APP_NET_REQUEST_DELAY_SEC, TimeUnit.SECONDS);
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind called");
        future.cancel(true);
        return super.onUnbind(intent);
    }

    protected Observable<List<AppNetRowData>> convertToAppNetRowData() {
        return getAppNetDataFromServer()
                .map(appNetData -> {
                    List<AppNetRowData> rowDataList = new ArrayList<>();
                    Log.d(TAG, "Num rows from server = " + appNetData.getData().size());
                    updateMeta(appNetData.getMeta());
                    for(Datum datum : appNetData.getData()) {
                        rowDataList.add(new AppNetRowData(datum.getId(),
                                datum.getUser().getUsername(),
                                datum.getText(),
                                datum.getUser().getAvatarImage().getUrl(),
                                datum.getCreatedAt()));
                    }
                    return rowDataList;
                });
    }


    protected void updateMeta(Meta receivedMeta) {
        //Do not update the max id, otherwise we will lose the latest id that we received from the server
        if(Util.isNullOrEmpty(receivedMeta.getMaxId()) && !receivedMeta.getMore()) {
            this.meta.setMore(false);
        } else {
            this.meta = receivedMeta;
        }
        Log.i(TAG, "Set saved meta to = " + meta.toString());
    }

    protected Observable<AppNetData> getAppNetDataFromServer() {
        if(meta.getMaxId().equals(Constants.APP_START_LAST_POST_ID)) {
            Log.d(TAG, "Request last 20");
            return appNetService.getGlobalMessages();
        } else if(!meta.getMore()) {
            Log.d(TAG, "Already have latest, skip request");
            meta.setMore(true); //Reset to true so we can retry in the next cycle if we have more data
            return Observable.empty();
        }
        Log.d(TAG, "Request next 10 since " + meta.getMaxId());
        return appNetService.getGlobalMessages(meta.getMaxId(), Constants.APP_NET_REQUEST_BATCH_SIZE);
    }
}
