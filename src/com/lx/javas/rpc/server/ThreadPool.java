package com.lx.javas.rpc.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器端线程池
 * Created by lx on 2016/4/26.
 */
public class ThreadPool {


    //线程池
    ExecutorService pool;


    public ThreadPool(int capacity){
        pool = Executors.newFixedThreadPool(capacity);
    }


    public ThreadPool(){
        this(8);
    }


    /**
     * 运行所给线程
     * @param r
     */
    public void execute(Runnable r){
        pool.execute(r);
    }


    /**
     * 关闭线程池
     */
    public void shutdown(){
        pool.shutdown();
    }
}
