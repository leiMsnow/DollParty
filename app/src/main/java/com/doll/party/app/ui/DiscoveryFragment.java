package com.doll.party.app.ui;

import android.os.Bundle;

import com.doll.party.app.R;
import com.ray.core.BaseFragment;

public class DiscoveryFragment extends BaseFragment {

    public static DiscoveryFragment newInstance() {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initData() {

    }
}
