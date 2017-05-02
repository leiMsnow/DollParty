package com.doll.party.app.base;


import com.ray.core.BaseActivity;

/**
 * Created by zhangleilei on 2017/5/2.
 */

public abstract class BaseAppActivity extends BaseActivity {


    @Override
    protected boolean includeToolbar() {
        return true;
    }
}
