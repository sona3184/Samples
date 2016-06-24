package com.karson.portfolio.adnfeed.model;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by smuthuvijayan on 6/24/16.
 */

public class AppNetRowDataBus {

    private static AppNetRowDataBus instance;

    private PublishSubject<AppNetRowData> subject = PublishSubject.create();

    public static AppNetRowDataBus instanceOf() {
        if (instance == null) {
            instance = new AppNetRowDataBus();
        }
        return instance;
    }

    /**
     * Pass a row data down to event listeners.
     */
    public void addAppNetRowData(AppNetRowData rowData) {
        subject.onNext(rowData);
    }

    /**
     * Subscribe to this Observable
     */
    public Observable<AppNetRowData> getStringObservable() {
        return subject;
    }

}
