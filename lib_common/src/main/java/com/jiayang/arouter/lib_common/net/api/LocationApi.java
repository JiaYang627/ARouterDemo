package com.jiayang.arouter.lib_common.net.api;

import com.jiayang.arouter.lib_common.net.bean.LocationBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ：张 奎
 * @date ：2018-06-11 14：21
 * 邮箱   ：JiaYang627@163.com
 */
public interface LocationApi {
    String KEY = "daf8fa858c330b22e342c882bcbac622";
    String BASE_URL = "http://apis.juhe.cn/";
    @GET("mobile/get")
    Observable<LocationBean> getLocation(@Query("phone") String phoneNumber, @Query("key") String key);
}
