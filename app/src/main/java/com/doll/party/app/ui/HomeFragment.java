package com.doll.party.app.ui;

import android.os.Bundle;

import com.doll.party.app.R;
import com.ray.core.BaseFragment;

public class HomeFragment extends BaseFragment {

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

    }
}
