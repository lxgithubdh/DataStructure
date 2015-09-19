package com.lx.main;


import com.lx.looper.Looper;
import com.lx.looper.Message;
import com.lx.looper.Result;

import java.util.concurrent.Future;

/**
 * 运行入口
 * @author lx
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
        Looper looper = Looper.getInstance();
        Message message = new Message();
        for (int i = 0; i < 30; i++) {
            message.what = i;
            looper.sendMessage(message);
            System.out.println(i);
            Thread.sleep(500);
        }
        Future<Result> future = looper.sendMessageWithResult(message);
        System.out.println(future.get());
    }

}
