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


    public ProxyServer(){
        init();
    }


    public void startService(){
        while(true){
            Socket socket = null;
            try {
                socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new ServiceThread(socket).start();
        }
    }


    /**
     * 初始化方法
     */
    private void init(){
        try {
            server = new ServerSocket(Constant.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
