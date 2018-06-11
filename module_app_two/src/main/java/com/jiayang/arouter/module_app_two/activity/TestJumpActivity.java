package com.jiayang.arouter.module_app_two.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jiayang.arouter.lib_common.Constant;
import com.jiayang.arouter.lib_common.common.BaseActivity;
import com.jiayang.arouter.module_app_two.R;
import com.jiayang.arouter.module_app_two.presenter.TestJumpActivityPresenter;
import com.jiayang.arouter.module_app_two.viewipm.TestJumpActivityIpm;

/**
 * @author ：张 奎
 * @date ：2018-06-11 16：06
 * 邮箱   ：JiaYang627@163.com
 */

@Route(path = Constant.PATH_TWO_TEST)
public class TestJumpActivity extends BaseActivity<TestJumpActivityPresenter> implements TestJumpActivityIpm{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new TestJumpActivityPresenter(this, getIntent());
    }
}
