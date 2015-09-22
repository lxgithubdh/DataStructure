package com.lx.javas.looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * Created by lx on 2015/9/19.
 */
public class ThreadPool {

    //线程池
    ExecutorService pool;


    public ThreadPool(int capacity){
        pool = Executors.newFixedThreadPool(capacity);
    }


    /**
     * 执行线程,无返回值
     * @param worker
     */
    public void execute(AbstractWorker worker){
        pool.execute(worker);
    }
}
