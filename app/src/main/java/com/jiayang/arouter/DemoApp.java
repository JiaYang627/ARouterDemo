package com.jiayang.arouter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jiayang.arouter.lib_common.base.BaseApplication;
import com.jiayang.arouter.lib_common.utils.ConstantUtils;

/**
 * @author ：张 奎
 * @date ：2018-06-11 16：31
 * 邮箱   ：JiaYang627@163.com
 */
public class DemoApp extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();

        initARouter();
    }

    private void initARouter() {
        if (ConstantUtils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
