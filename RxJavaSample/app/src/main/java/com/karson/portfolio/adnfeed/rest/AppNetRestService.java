package com.karson.portfolio.adnfeed.rest;

import com.karson.portfolio.adnfeed.model.AppNetData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by smuthuvijayan on 6/15/16.
 */

public interface AppNetRestService {

    String APP_NET_SERVICE_ENDPOINT = "https://alpha-api.app.net";

    @GET("/stream/posts/stream/global")
    Observable<AppNetData> getGlobalMessages();

    @GET("/stream/posts/stream/global")
    Observable<AppNetData> getGlobalMessages(@Query("since_id") String sinceId, @Query("count") Integer count);
}

