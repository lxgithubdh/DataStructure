package com.lx.javas.rpc.server;

/**
 * 接收消息回调
 * Created by lx on 2016/4/27.
 */
public interface OnReceiveMessage {


    /**
     * 发送消息
     * @param msg
     */
    void send(String msg);
}
