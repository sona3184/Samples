package com.example.smuthuvijayan.rxsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.smuthuvijayan.rxsample.R;
import com.example.smuthuvijayan.rxsample.model.AppNetData;
import com.example.smuthuvijayan.rxsample.model.Datum;
import com.example.smuthuvijayan.rxsample.rest.AppNetRestService;
import com.example.smuthuvijayan.rxsample.rest.RestServiceFactory;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppNetStreamActivity extends AppCompatActivity {

    private static final String TAG = "AppNetSreamActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_net_stream);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchAppNetData();
    }

    protected void fetchAppNetData() {
        AppNetRestService appNetService = RestServiceFactory.createRetrofitService(AppNetRestService.class,
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
}
