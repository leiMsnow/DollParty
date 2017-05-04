package com.doll.party.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.chenenyu.router.annotation.Route;
import com.doll.party.app.R;
import com.doll.party.app.base.BaseAppActivity;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.ray.core.uils.LogUtils;

/**
 * 创建doll
 */
@Route("create_doll")
public class CreateDollActivity extends BaseAppActivity implements TakePhoto.TakeResultListener
,InvokeListener {

    private static final String TAG = CreateDollActivity.class.getName();

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_create_doll;
    }

    @Override
    protected void initData() {

    }

    /**
     *  获取TakePhoto实例
     * @return
     */
    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
        }
        return takePhoto;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getTakePhoto().onSaveInstanceState(outState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type=PermissionManager.onRequestPermissionsResult(requestCode,permissions,grantResults);
        PermissionManager.handlePermissionsResult(this,type,invokeParam,this);
    }



    @Override
    public void takeSuccess(TResult result) {
        LogUtils.i(TAG,"takeSuccess：" + result.getImage().getCompressPath());
    }

    @Override
    public void takeFail(TResult result, String msg) {
        LogUtils.i(TAG, "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        LogUtils.i(TAG, getResources().getString(R.string.msg_operation_canceled));
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type=PermissionManager.checkPermission(TContextWrap.of(this),invokeParam.getMethod());
        if(PermissionManager.TPermissionType.WAIT.equals(type)){
            this.invokeParam=invokeParam;
        }
        return type;
    }
}
