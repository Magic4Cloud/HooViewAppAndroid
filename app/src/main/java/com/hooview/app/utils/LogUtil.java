package com.hooview.app.utils;

import android.util.Log;

public class LogUtil {

    private final static String LOG_TAG = "TAG";

    private static boolean DEBUG = true;

    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(LOG_TAG, msg);
        }
    }

    public static void e(String msg) {
        e(LOG_TAG, msg);
    }

    public static void e(String msg, Throwable throwable) {
        e(LOG_TAG, msg, throwable);
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (DEBUG) {
            Log.e(tag, msg, throwable);
        }
    }

}
