package com.doll.party.app.ui;

import com.doll.party.app.R;
import com.doll.party.app.base.BaseAppActivity;

public class MainActivity extends BaseAppActivity {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        hideToolbarBack();
    }
}
