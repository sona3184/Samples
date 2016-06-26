package com.karson.portfolio.adnfeed;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by smuthuvijayan on 6/19/16.
 */

public class Util {

    public static long getLongFromTimeString(String time) {
        return DateTime.parse(time).withZone(DateTimeZone.forID(DateTimeZone.getDefault().getID())).getMillis();
    }

    public static boolean isNullOrEmpty(String str) {
        if(str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void writeToSharedPref(Context context, String key, String lastPostId) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, lastPostId);
        editor.commit();
    }

    public static String getFromSharedPref(Context context, String key) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPref.getString(key, Constants.APP_START_LAST_POST_ID);
    }

    /**
     * Checks the difference between the last post id in shared preferences and the since_id
     * of the post received from the server. If the difference is more than 100, just retrieve
     * the latest from the global stream.
     */
    public static boolean shouldResetToLatest(String savedLastPostId, String receivedLastPostId) {
        boolean retval = false;
        if(isNullOrEmpty(savedLastPostId)) {
            retval = true;
        } else {
            Long savedId = Long.parseLong(savedLastPostId);
            Long receivedId = Long.parseLong(receivedLastPostId);
            if(receivedId - savedId > Constants.MAX_APP_NET_POSTS)
                retval = true;
        }
        return retval;
    }
}
