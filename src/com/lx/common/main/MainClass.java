package com.lx.common.main;


import com.lx.javas.nio.HttpChannel;

/**
 * 运行入口
 * @author lx
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
        //new RmiTest().test();
		new HttpChannel().doGet("localhost");
    }
}