package com.lx.javas.rpc.client;

/**
 * 客户端工厂
 * Created by lx on 2016/4/19.
 */
public class ClientFactory {


    public static ISocketConnect createCommonClient(){
        return new CommonClient();
    }


    public static ISocketConnect createChatClient(){
        return new ChatClient();
    }
}
