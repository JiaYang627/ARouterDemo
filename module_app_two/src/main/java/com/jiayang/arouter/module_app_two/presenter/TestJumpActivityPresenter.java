package com.jiayang.arouter.module_app_two.presenter;

import android.content.Intent;
import android.text.TextUtils;

import com.jiayang.arouter.lib_common.common.BasePresenter;
import com.jiayang.arouter.lib_common.utils.ToastUtils;
import com.jiayang.arouter.module_app_two.viewipm.TestJumpActivityIpm;

/**
 * @author ：张 奎
 * @date ：2018-06-11 16：11
 * 邮箱   ：JiaYang627@163.com
 */
public class TestJumpActivityPresenter extends BasePresenter<TestJumpActivityIpm> {

    public TestJumpActivityPresenter(TestJumpActivityIpm testJumpActivityIpm, Intent intent) {
        super(testJumpActivityIpm, intent);
    }

    @Override
    public void onTakeView() {
        super.onTakeView();
        String aaa = intent.getStringExtra("AAA");
        if (!TextUtils.isEmpty(aaa)) {
            ToastUtils.initToast(aaa);
        }
    }
}
