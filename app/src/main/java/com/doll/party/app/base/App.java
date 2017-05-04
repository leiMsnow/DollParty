package com.doll.party.app.base;


import com.ray.core.CoreApplication;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by zhangleilei on 2017/5/2.
 */

public class App extends CoreApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        BmobConfig config = new BmobConfig.Builder(this)
                .setApplicationId("db39c4a38f338035d1a20d393cdfbcbb")
                .setConnectTimeout(30).build();
        Bmob.initialize(config);
    }
}
