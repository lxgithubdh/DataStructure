package com.lx.javas.rpc.server;

import com.lx.common.constant.Constant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 代理服务器
 * Created by lx on 2015/10/26.
 */
public class ProxyServer {


    //服务器socket
    private ServerSocket server;
    //线程池
    private ThreadPool pool;


    public ProxyServer(){
        pool = new ThreadPool();
        init();
    }


    /**
     * 打开服务
     */
    public void startService(){
        while(true){
            Socket socket = null;
            try {
                socket = server.accept();  //获取连接的socket
                System.out.println("Server accept " +
                        socket.getInetAddress()+":"+socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            }
            pool.execute(new ServiceThread(socket));   //将socket委托线程处理
            System.out.println("Server thread start ...");
        }
    }


    /**
     * 初始化方法
     */
    private void init(){
        try {
            server = new ServerSocket(Constant.SERVER_PORT);
            System.out.println("Server start ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
