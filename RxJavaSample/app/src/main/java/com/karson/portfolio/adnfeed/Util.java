package com.karson.portfolio.adnfeed;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;


/**
 * Created by smuthuvijayan on 6/19/16.
 */

public class Util {

    public static long getLongFromTimeString(String time) {
        return DateTime.parse(time).withZone(DateTimeZone.forID("US/Pacific")).getMillis();
    }
}
