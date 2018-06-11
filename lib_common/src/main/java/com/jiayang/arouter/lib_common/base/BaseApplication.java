package com.jiayang.arouter.lib_common.base;

import android.app.Application;

/**
 * @author ：张 奎
 * @date ：2018-06-11 13：50
 * 邮箱   ：JiaYang627@163.com
 *
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件模块中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件模块的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件模块中获取Context的方法必须为:Util.getAPPContext()，不允许其他写法；
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseAppDeletage baseAppDeletage = new BaseAppDeletage(this);
        baseAppDeletage.onCreate();
    }
}
