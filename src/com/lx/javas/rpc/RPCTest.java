package com.lx.javas.rpc;

import com.lx.javas.rpc.client.ClientFactory;
import com.lx.javas.rpc.client.ISocketConnect;
import com.lx.javas.rpc.server.ProxyServer;

import java.util.Scanner;

/**
 * rpc测试代码
 * Created by lx on 2016/6/7.
 */
public class RPCTest {


    /**
     * 启动客户端
     * @throws Exception
     */
    public void startClient() throws Exception{
        ISocketConnect service = ClientFactory.createCommonClient();
        service.open();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            String content = scanner.nextLine();
            if(content.equals("close")){
                flag = false;
            }
            service.call(content);
        }
        service.close();
    }


    /**
     * 启动服务器
     */
    public static void startServer(){
        ProxyServer server = new ProxyServer();
        server.startService();
    }
}
