package com.karson.portfolio.adnfeed.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.karson.portfolio.adnfeed.R;
import com.karson.portfolio.adnfeed.adapter.AppNetMessageAdapter;
import com.karson.portfolio.adnfeed.model.AppNetRowData;
import com.karson.portfolio.adnfeed.model.AppNetRowDataBus;
import com.karson.portfolio.adnfeed.model.Datum;
import com.karson.portfolio.adnfeed.service.AppNetService;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppNetStreamActivity extends AppCompatActivity {

    private static final String TAG = "AppNetSreamActivity";

    @BindView(R.id.message_card_list) RecyclerView messageCardList;

    AppNetMessageAdapter adapter;

    Observable<AppNetRowData> appNetTopic;


    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_net_stream);
        ButterKnife.bind(this);
        JodaTimeAndroid.init(this);
        Fabric.with(this, new Crashlytics());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        messageCardList.setLayoutManager(layoutManager);

        adapter = new AppNetMessageAdapter(new ArrayList<AppNetRowData>());
        messageCardList.setAdapter(adapter);
        Intent intent = new Intent(this, AppNetService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppNetRowDataBus.instanceOf().getStringObservable().subscribe(appNetRowData -> {
            Log.i(TAG, "Received data from event bus : " + appNetRowData.getId());
            adapter.addData(appNetRowData);
        }, throwable -> {
            Log.e(TAG, "Error receiving data on event bus", throwable);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unbind from the service
        if (mBound) {
            AppNetRowDataBus.instanceOf().getStringObservable().unsubscribeOn(Schedulers.newThread());
            unbindService(mConnection);
            mBound = false;
        }
    }

    /**
     * Implement callbacks for service connect/disconnect
     */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            mBound = true;
            AppNetService.AppNetServiceBinder binder = (AppNetService.AppNetServiceBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
            appNetTopic.unsubscribeOn(Schedulers.newThread());
        }
    };
}
