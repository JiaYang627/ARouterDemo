package com.jiayang.arouter.module_app_one.presenter;

import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jiayang.arouter.lib_common.Constant;
import com.jiayang.arouter.lib_common.base.BasePresenter;
import com.jiayang.arouter.lib_common.net.ServerUtils;
import com.jiayang.arouter.lib_common.net.api.LocationApi;
import com.jiayang.arouter.lib_common.net.bean.LocationBean;
import com.jiayang.arouter.lib_common.net.callback.RequestCallback;
import com.jiayang.arouter.lib_common.net.callback.RxErrorHandler;
import com.jiayang.arouter.lib_common.utils.ConstantUtils;
import com.jiayang.arouter.lib_common.utils.RetryWithDelay;
import com.jiayang.arouter.lib_common.utils.RxUtils;
import com.jiayang.arouter.lib_common.utils.ToastUtils;
import com.jiayang.arouter.module_app_one.viewipm.MainActivityIpm;

/**
 * @author ：张 奎
 * @date ：2018-06-11 15：00
 * 邮箱   ：JiaYang627@163.com
 */
public class MainActivityPresenter extends BasePresenter<MainActivityIpm> {
    public MainActivityPresenter(MainActivityIpm mainActivityIpm, Intent intent) {
        super(mainActivityIpm, intent);
    }

    public void goToGetInfo() {

        ServerUtils.getCommonApi().getLocation("13838385438" , LocationApi.KEY)
                .retryWhen(new RetryWithDelay(3,2))
                .compose(RxUtils.<LocationBean>bindToLifecycle(getView()))
                .compose(RxUtils.<LocationBean>getSchedulerTransformer())
                .subscribe(new RequestCallback<LocationBean>(RxErrorHandler.getInstance()) {
                    @Override
                    public void onNext(LocationBean locationBean) {
                        super.onNext(locationBean);
                        ToastUtils.initToast(locationBean.result.city);
                    }
                });
    }

    public void goToJump() {
//        ARouter.getInstance()
//                .build(Constant.PATH_TWO_TEST)
//                .navigation(ConstantUtils.getAPPContext());

        ARouter.getInstance()
                .build(Constant.PATH_TWO_TEST)
                .withString("AAA", "测试跳转携带数据")
                .navigation(ConstantUtils.getAPPContext());

    }
}
