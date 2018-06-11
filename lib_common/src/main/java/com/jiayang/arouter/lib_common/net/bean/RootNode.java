package com.jiayang.arouter.lib_common.net.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 返回数据结构 一级分类
 */

public class RootNode<T> {

    @JSONField(name = "code")
    public int flagCode;
    @JSONField(name = "errmsg")
    public String errorMsg;
    @JSONField(name = "body")
    public T data;
    @JSONField(name = "status")
    public int status;
    @JSONField(name = "time")
    public String time;

}
