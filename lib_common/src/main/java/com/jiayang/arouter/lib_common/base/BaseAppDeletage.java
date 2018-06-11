package com.jiayang.arouter.lib_common.base;

import android.app.Application;

import com.jiayang.arouter.lib_common.utils.ConstantUtils;
import com.jiayang.arouter.lib_common.utils.LogUtils;
import com.jiayang.arouter.lib_common.utils.PreferenceTool;
import com.jiayang.arouter.lib_common.utils.ToastUtils;

/**
 * @author ：张 奎
 * @date ：2018-06-11 13：51
 * 邮箱   ：JiaYang627@163.com
 */
public class BaseAppDeletage {

    private Application mApplication;

    public BaseAppDeletage(Application application) {
        mApplication = application;
    }

    public void onCreate() {
        ConstantUtils.init(mApplication);    //全局Utils
        initLog();                          //Log日志
        PreferenceTool.init(mApplication);   //Preference参数
        ToastUtils.init(mApplication);       //吐司初始化
    }

    private void initLog() {
        LogUtils.setLogEnable(ConstantUtils.isAppDebug());
    }

}
