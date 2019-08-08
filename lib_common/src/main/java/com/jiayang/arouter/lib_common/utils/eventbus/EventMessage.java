package com.jiayang.arouter.lib_common.utils.eventbus;

import java.io.Serializable;

/**
 * <p>描述：用EventBus发送的消息 </p>
 *
 */
public class EventMessage implements Serializable {

    /**
     *
     * @param msg
     * @param obj
     * @param type {@link EventMessageType}
     */
    public EventMessage(String msg, Object obj, int type) {
        this.msg = msg;
        this.obj = obj;
        this.type = type;
    }

    /**
     *
     * @param msg
     * @param type {@link EventMessageType}
     */
    public EventMessage(String msg, int type) {
        this.msg = msg;
        this.type = type;
    }
    /**
     *
     * @param msg
     * @param type {@link EventMessageType}
     */
    public EventMessage(String msg, String str, int type) {
        this.msg = msg;
        this.str = str;
        this.type = type;
    }

    /**
     *
     * @param type {@link EventMessageType}
     */
    public EventMessage(int type) {
        this.type = type;
    }

    public EventMessage() {
    }


    public String msg;
    public String str;
    public Object obj;

    /**
     * {@link EventMessageType}
     */
    public int type;

    @Override
    public String toString() {
        return "EventMessage{" +
                "msg='" + msg + '\'' +
                ", obj=" + obj +
                ", type=" + type +
                '}';
    }
}
