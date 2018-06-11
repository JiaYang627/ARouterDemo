package com.jiayang.arouter.lib_common.common;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @author ：张 奎
 * @date ：2018-06-11 14：43
 * 邮箱   ：JiaYang627@163.com
 */
public abstract class BaseActivity  <Presenter extends BasePresenter> extends RxAppCompatActivity {
    public Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    protected abstract int getLayoutId();

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config,res.getDisplayMetrics() );
        return res;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onTakeView();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onViewDestroy();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mPresenter.onNewIntent(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (mPresenter != null) {
            if (mPresenter.getView() instanceof Activity) {
                mPresenter.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
