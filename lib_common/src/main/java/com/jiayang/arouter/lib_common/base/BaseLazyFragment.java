package com.jiayang.arouter.lib_common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * @author ：张 奎
 * @date ：2018-06-11 21：14
 * 邮箱   ：JiaYang627@163.com
 * 懒加载 BaseFragment
 */
public class BaseLazyFragment<Presenter extends BaseLazyPresenter> extends RxFragment {

    protected Presenter mPresenter;
    protected boolean presenterFactoryPrepared;
    protected boolean isVisible;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterFactoryPrepared = true;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        if (!presenterFactoryPrepared){
            return;
        }
        lazyLoad();
    }
    protected void onInvisible() {
    }

    //懒加载的方法,在这个方法里面我们为Fragment的各个组件去添加数据
    protected void lazyLoad(){
        if (mPresenter != null) {
            mPresenter.setVisible(isVisible);
            mPresenter.preLazyLoad();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.getArguments(getArguments());
            mPresenter.onTakeView();
        }
        onVisible();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onViewDestroy();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mPresenter != null) {
            mPresenter.onHiddenChanged(hidden);
        }
    }

    public void onPermissionsGranted(int code, String[] permissions){}
}
