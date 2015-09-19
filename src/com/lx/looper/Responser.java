package com.lx.looper;

/**
 *可以返回值的线程
 * Created by lx on 2015/9/19.
 */
public class Responser extends AbstractResponser{


    public Responser(Message msg){
        super(msg);
    }


    @Override
    public Result call() throws Exception {
        System.out.println("This is responser :");
        System.out.println("Current thread :"+Thread.currentThread().getName());
        System.out.println("Current msg :"+msg.what);
        return new Result(0,String.valueOf(msg.what));
    }
}
