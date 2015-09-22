package com.lx.javas.looper;

/**
 * 消息处理线程抽象类
 * Created by lx on 2015/9/19.
 */
public abstract class AbstractWorker implements Runnable{

    //消息信息
    protected Message msg;


    public AbstractWorker(Message msg){
        this.msg = msg;
    }
}
