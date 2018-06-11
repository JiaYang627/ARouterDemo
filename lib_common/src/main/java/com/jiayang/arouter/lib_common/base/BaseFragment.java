package com.jiayang.arouter.lib_common.base;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * @author ：张 奎
 * @date ：2018-06-11 21：04
 * 邮箱   ：JiaYang627@163.com
 */
public class BaseFragment<Presenter extends BasePresenter> extends RxFragment {

    protected Presenter mPresenter;

    @Override
    public void onResume() {
        super.onResume();

        if (mPresenter != null) {
            mPresenter.onTakeView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onViewDestroy();
        }
    }

    public void onPermissionsGranted(int code, String[] permissions){}
}
