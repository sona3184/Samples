package com.example.smuthuvijayan.rxsample.rest;

import com.example.smuthuvijayan.rxsample.model.AppNetData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by smuthuvijayan on 6/15/16.
 */

public interface AppNetRestService {

    String APP_NET_SERVICE_ENDPOINT = "https://alpha-api.app.net";

    @GET("/stream/posts/stream/global")
    Observable<AppNetData> getGlobalMessages();
}

