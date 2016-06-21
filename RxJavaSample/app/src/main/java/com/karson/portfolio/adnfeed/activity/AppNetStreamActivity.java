package com.karson.portfolio.adnfeed.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.karson.portfolio.adnfeed.R;
import com.karson.portfolio.adnfeed.adapter.AppNetMessageAdapter;
import com.karson.portfolio.adnfeed.model.AppNetData;
import com.karson.portfolio.adnfeed.model.Datum;
import com.karson.portfolio.adnfeed.rest.AppNetRestService;
import com.karson.portfolio.adnfeed.rest.RestServiceFactory;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppNetStreamActivity extends AppCompatActivity {

    private static final String TAG = "AppNetSreamActivity";

    @BindView(R.id.message_card_list) RecyclerView messageCardList;
    AppNetMessageAdapter adapter;

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

        adapter = new AppNetMessageAdapter(new ArrayList<Datum>(20));
        messageCardList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchAppNetData();
    }

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
                        adapter.addData(appNetData.getData());
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
