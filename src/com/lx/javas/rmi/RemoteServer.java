package com.lx.javas.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * 远程服务器类
 * Created by lx on 2016/6/7.
 */
public class RemoteServer {

    //上下文
    private Context context;


    public RemoteServer() throws NamingException {
        context = new InitialContext();
    }


    /**
     * 注册远程调用
     */
    public void registerMethod() throws NamingException, RemoteException {
        context.bind("rmi:all",new RemoteCallImpl());
    }
}
