package com.doll.party.app.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.doll.party.app.R;
import com.ray.core.BaseFragment;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class HomeFragment extends BaseFragment {

    @Bind(R.id.rv_container)
    RecyclerView rvContainer;
    @Bind(R.id.ptr_layout)
    PtrFrameLayout ptrLayout;

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
        initPtrHandler();
    }

    private void initPtrHandler(){
        ptrLayout.setPtrHandler(ptrHandler);
    }

    private PtrHandler ptrHandler = new PtrDefaultHandler() {
        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            frame.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ptrLayout.refreshComplete();
                }
            }, 1800);
        }
    };
}
