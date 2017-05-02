package com.ray.core;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by zhangleilei on 8/31/16.
 */
public class CoreApplication extends Application {

    private static CoreApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        BmobConfig config = new BmobConfig.Builder(this)
                .setApplicationId("db39c4a38f338035d1a20d393cdfbcbb")
                .setConnectTimeout(30).build();
        Bmob.initialize(config);


        mApplication = this;
//        FileDownloader.init(getApplicationContext());
    }
    public static CoreApplication getApplication() {
        return mApplication;
    }
}
