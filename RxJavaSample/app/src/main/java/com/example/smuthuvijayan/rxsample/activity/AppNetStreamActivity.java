package com.example.smuthuvijayan.rxsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.smuthuvijayan.rxsample.R;
import com.example.smuthuvijayan.rxsample.adapter.AppNetMessageAdapter;
import com.example.smuthuvijayan.rxsample.model.AppNetData;
import com.example.smuthuvijayan.rxsample.model.Datum;
import com.example.smuthuvijayan.rxsample.rest.AppNetRestService;
import com.example.smuthuvijayan.rxsample.rest.RestServiceFactory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
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

       /* Observable.interval(5, TimeUnit.SECONDS, Schedulers.io())
                .map(tick -> appNetService.getGlobalMessages());*/
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
