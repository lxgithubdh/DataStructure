package com.lx.looper;

/**
 * 存储消息信息
 * Created by lx on 2015/9/19.
 */
public class Message implements Cloneable{

    //消息类型
    public int what;


    public Message(){

    }


    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
