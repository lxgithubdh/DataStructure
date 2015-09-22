package com.lx.javas.looper;

/**
 * 工作线程
 * Created by lx on 2015/9/19.
 */
public class Worker extends AbstractWorker{



    public Worker(Message msg){
        super(msg);
    }


    @Override
    public void run() {
        System.out.println("This is worker :");
        System.out.println("Current thread :"+Thread.currentThread().getName());
        System.out.println("Current msg :" + msg.what);
    }
}
