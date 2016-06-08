package com.lx.javas.rmi;

/**
 * 远程方法调用测试
 * Created by lx on 2016/6/7.
 */
public class RmiTest {

    public void test() throws Exception{
        RemoteServer server = new RemoteServer();
        server.registerMethod();
        RemoteClient client = new RemoteClient();
        //client.remoteCall("Tom");
    }
}
