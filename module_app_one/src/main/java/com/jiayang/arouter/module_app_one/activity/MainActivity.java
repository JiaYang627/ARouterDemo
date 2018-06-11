package com.jiayang.arouter.module_app_one.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jiayang.arouter.lib_common.common.BaseActivity;
import com.jiayang.arouter.module_app_one.R;
import com.jiayang.arouter.module_app_one.presenter.MainActivityPresenter;
import com.jiayang.arouter.module_app_one.viewipm.MainActivityIpm;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements View.OnClickListener ,MainActivityIpm{


    private Button mButtonForToast;
    private Button mButtonForJump;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new MainActivityPresenter(this, getIntent());
        initView();
    }

    private void initView() {
        mButtonForToast = findViewById(R.id.mainButtonForToast);
        mButtonForJump = findViewById(R.id.mainButtonForJump);

        mButtonForToast.setOnClickListener(this);
        mButtonForJump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mainButtonForJump) {
            mPresenter.goToJump();
        } else if (v.getId() == R.id.mainButtonForToast) {
            mPresenter.goToGetInfo();
        }
    }
}
