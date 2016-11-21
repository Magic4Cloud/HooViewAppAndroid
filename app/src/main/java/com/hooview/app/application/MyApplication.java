package com.hooview.app.application;

import android.app.Application;
import android.content.Context;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by yinyongliang on 16/11/16.
 * 项目中的application
 */
public class MyApplication extends Application {

    private static Context mAppContext;

    static {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        mAppContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
