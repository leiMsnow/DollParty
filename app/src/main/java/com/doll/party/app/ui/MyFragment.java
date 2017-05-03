package com.doll.party.app.ui;

import android.os.Bundle;

import com.doll.party.app.R;
import com.ray.core.BaseFragment;

public class MyFragment extends BaseFragment {

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }
}
