package com.example.smuthuvijayan.rxsample;

import org.joda.time.DateTime;


/**
 * Created by smuthuvijayan on 6/19/16.
 */

public class Util {

    public static long getLongFromTimeString(String time) {
        return DateTime.parse(time).getMillis();
    }
}
