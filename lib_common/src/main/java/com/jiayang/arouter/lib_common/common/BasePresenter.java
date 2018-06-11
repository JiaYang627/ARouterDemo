package com.jiayang.arouter.lib_common.common;

import android.content.Intent;
import android.os.Bundle;

import com.jiayang.arouter.lib_common.base.BaseViewIpm;

/**
 * @author ：张 奎
 * @date ：2018-06-11 14：45
 * 邮箱   ：JiaYang627@163.com
 */
public class BasePresenter<View extends BaseViewIpm> {
    private View mView;
    protected Intent intent;


    public BasePresenter(View view, Intent intent) {
        this.mView = view;
        this.intent = intent;
        attachView(view);
    }


    public View getView(){
        return mView;
    }

    protected void attachView(BaseViewIpm view){

    }
    /**
     * 页面跳转 携带数据过来 Pst写此方法拿数据
     * @param intent
     */
    public void getData(Intent intent) {

    }

    /**
     * 页面跳转 数据回传 Pst写此方法拿回传数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
    private boolean isViewAttach;

    /**
     * 如果需要进来就要联网请求数据，Pst 中覆写此方法
     */
    public void onTakeView() {

        if (!isViewAttach) {
            isViewAttach = true;
            onOnceTakeView();
        }

    }
    /**
     * 如果只需要第一次加载页面联网请求数据，Pst 中覆写次方法
     */
    public void onOnceTakeView() {

    }



    public void onHiddenChanged(boolean hidden) {

    }

    public void getArguments(Bundle bundle) {

    }

    protected void handleNetError() {

    }

    public void onNewIntent(Intent intent) {

    }

    public void onViewDestroy() {

    }
}
