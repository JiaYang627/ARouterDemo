package com.jiayang.arouter.lib_common.base;

import android.content.Intent;

/**
 * @author ：张 奎
 * @date ：2018-06-11 21：15
 * 邮箱   ：JiaYang627@163.com
 * 懒加载 FragmentPresenter
 */
public abstract class BaseLazyPresenter<View extends BaseViewIpm> extends BasePresenter<View> {

    private boolean mIsPrepared;
    private boolean mBoolean;
    private boolean allowLoad = true; // 如果需要（重新）加载，这个变量在preLazyLoad中设置为true
    public BaseLazyPresenter(View view, Intent intent) {
        super(view, intent);
    }

    @Override
    public void onTakeView() {
        super.onTakeView();
        mIsPrepared = true;
        preLazyLoad();
    }

    public void preLazyLoad() {
        if (!mIsPrepared || !mBoolean) {
            return;
        }
        if (!allowLoad) {
            return;
        }
        allowLoad = false;
        lazyLoad();
    }

    protected abstract void lazyLoad();

    public void setVisible(boolean isVisible) {
        mBoolean = isVisible;
    }
}
