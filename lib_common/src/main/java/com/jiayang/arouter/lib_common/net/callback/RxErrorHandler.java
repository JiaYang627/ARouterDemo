package com.jiayang.arouter.lib_common.net.callback;

import com.jiayang.arouter.lib_common.R;
import com.jiayang.arouter.lib_common.utils.ConstantUtils;
import com.jiayang.arouter.lib_common.utils.LogUtils;
import com.jiayang.arouter.lib_common.utils.ToastUtils;

public class RxErrorHandler implements ErrorListener{

    private volatile static RxErrorHandler rxErrorHandler;

    private RxErrorHandler(){

    }

    public static RxErrorHandler getInstance(){
        if (rxErrorHandler == null) {
            synchronized (RxErrorHandler.class) {
                if (rxErrorHandler == null) {
                    rxErrorHandler = new RxErrorHandler();
                }
            }
        }
        return rxErrorHandler;
    }

    @Override
    public void handleError(Throwable throwable) {
        String errorString = throwable.toString();
        LogUtils.e("aaaa==============" + throwable.toString());
        //返回的错误为空
        if (errorString == null) {
            ToastUtils.initToast(ConstantUtils.getAPPContext().getString(R.string.generic_server_down));
            //            ToastUtils.initToast("网络数据异常，请重试");
        }
        //请求超时
        if (errorString.contains("TimeoutException") || errorString.contains("SocketTimeoutException")) {
            ToastUtils.initToast(ConstantUtils.getAPPContext().getString(R.string.request_time_out));
            //            ToastUtils.initToast("网络请求超时，请重试");
        }
        //能识别的请求异常，忽略不提示
        if (errorString.contains("SSLException")) {

        }
        //403、404等服务错误
        if (errorString.contains("ServiceConfigurationError") || errorString.contains("AuthenticatorException")) {
            ToastUtils.initToast(ConstantUtils.getAPPContext().getString(R.string.generic_server_down));
            //            ToastUtils.initToast("网络数据异常，请重试");
        }
        //网络未连接
        if (errorString.contains("NetworkErrorException") || errorString.contains("NoConnectionPendingException") || errorString.contains("UnknownHostException")) {
            ToastUtils.initToast(ConstantUtils.getAPPContext().getString(R.string.network_hint));
            //            ToastUtils.initToast("您的网络不给力，请检查网络设置");
        }
        //连接不到服务器
        if (errorString.contains("ConnectException")) {
            ToastUtils.initToast(ConstantUtils.getAPPContext().getString(R.string.fail_to_connected) );
            //            ToastUtils.initToast("网络连接失败");
        }
    }
}