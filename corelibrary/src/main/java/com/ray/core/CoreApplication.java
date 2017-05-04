package com.ray.core;

import android.app.Application;

import com.chenenyu.router.Router;

/**
 * Created by zhangleilei on 8/31/16.
 */
public class CoreApplication extends Application {

    private static CoreApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        Router.initialize(this);
        mApplication = this;
//        FileDownloader.init(getApplicationContext());
    }
    public static CoreApplication getApplication() {
        return mApplication;
    }
}
