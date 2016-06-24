package com.karson.portfolio.adnfeed.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.common.collect.EvictingQueue;
import com.karson.portfolio.adnfeed.model.AppNetRowData;
import com.karson.portfolio.adnfeed.model.AppNetRowDataBus;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Queue;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by smuthuvijayan on 6/24/16.
 */

public class AppNetService extends Service {

    public static String TAG = AppNetService.class.getSimpleName();

    private static final int MAX_APP_NET_POSTS = 100;

    private final IBinder mBinder = new AppNetServiceBinder();

    Queue<AppNetRowData> appNewRowDataQueue = EvictingQueue.create(MAX_APP_NET_POSTS);

    public class AppNetServiceBinder extends Binder {
        public AppNetService getService() {
            return AppNetService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called");
        startSendingDummmyData();
        return mBinder;
    }

    private void startSendingDummmyData() {
        Integer id = 1;

        while (id <= 10) {
            AppNetRowData data = new AppNetRowData(Integer.toString(id),
                    "user" + id,
                    "Post text " + id,
                    "https://lh4.ggpht.com/mJDgTDUOtIyHcrb69WM0cpaxFwCNW6f0VQ2ExA7dMKpMDrZ0A6ta64OCX3H-NMdRd20=w300",
                    new DateTime(DateTimeZone.UTC).toString());
            AppNetRowDataBus.instanceOf().addAppNetRowData(data);
            id++;
        }
    }

    /*
    protected void fetchAppNetData() {
        final AppNetRestService appNetService = RestServiceFactory.createRetrofitService(AppNetRestService.class,
                AppNetRestService.APP_NET_SERVICE_ENDPOINT);

        appNetService.getGlobalMessages()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppNetData>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "Data get completed");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AppNetData appNetData) {
                        Log.i(TAG, "Received data count = " + appNetData.getData().size());
                        for(Datum datum : appNetData.getData()) {
                            Log.i(TAG, datum.getId()
                                    + " | " + datum.getCreatedAt()
                                    + " | " + datum.getText()
                                    + " | " + datum.getUser().getUsername()
                                    + " | " + datum.getUser().getAvatarImage().getUrl());
                        }
                    }
                });
    }
     */
}
