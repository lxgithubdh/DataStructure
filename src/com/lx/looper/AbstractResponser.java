package com.lx.looper;

import java.util.concurrent.Callable;

/**
 * 处理消息抽象类，有返回值
 * Created by lx on 2015/9/19.
 */
public abstract class AbstractResponser implements Callable<Result>{


    //消息信息
    protected Message msg;


    public AbstractResponser(Message msg){
        this.msg = msg;
    }
}
