package debug;

import android.content.Context;

import com.jiayang.arouter.lib_common.base.BaseApplication;

/**
 * @author ：张 奎
 * @date ：2018-06-11 15：33
 * 邮箱   ：JiaYang627@163.com
 */
public class AppOneApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();

    }
}
