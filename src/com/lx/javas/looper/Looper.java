package com.lx.javas.looper;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * 处理消息循环
 * Created by lx on 2015/9/19.
 */
public class Looper {

    //全局Looper对象
    private static Looper looper = null;
    //消息队列
    private Queue<Message> queue;


    private Looper() {
        queue = new ArrayBlockingQueue<Message>(100);
        new MessageHandler(20).start();
    }


    /**
     * 获取Looper实例
     * @return
     */
    public static Looper getInstance() {
        if (null == looper) {
            synchronized (Looper.class) {
                if (null == looper) {
                    looper = new Looper();
                }
            }
        }
        return looper;
    }


    /**
     * 发送消息
     * @param msg
     * @return  是否发送成功 true表示发送成功；false表示消息队列已满，发送失败
     */
    public boolean sendMessage(Message msg){
        return queue.offer((Message)msg.clone());
    }


    /**
     * 发送信息，并取得返回值
     * @param msg
     * @return
     */
    public Future<Result> sendMessageWithResult(Message msg){
        FutureTask<Result> task = new FutureTask<Result>(new Responser(msg));
        new Thread(task).start();
        return task;
    }


    /**
     * 处理消息队列中的消息
     * @author lx
     */
    class MessageHandler extends Thread {
        Message message = null;
        //线程池
        ThreadPool pool;


        public MessageHandler(int capacity){
            pool = new ThreadPool(capacity);
        }


        @Override
        public void run() {
            while (true){
                message = queue.poll();
                if(null!=message){
                    handler(message);
                }
            }
        }


        /**
         * 处理消息,无返回值
         * @param msg
         */
        private void handler(Message msg){
            pool.execute(new Worker(msg));
        }
    }
}
