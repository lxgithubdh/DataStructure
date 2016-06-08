package com.lx.javas.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * 远程调用客户端
 * Created by lx on 2016/6/7.
 */
public class RemoteClient {

    //上下文
    private Context context;


    public RemoteClient() throws NamingException {
        context = new InitialContext();
    }


    /**
     * 调用远程方法
     * @param msg
     * @throws RemoteException
     */
    public void remoteCall(String msg) throws RemoteException, NamingException {
        IRemoteCall call = (IRemoteCall)context.lookup("rmi://192.168.1.101/call");
        String respond = call.call(msg);
        if(null==respond){
            respond = "Error Occur !";
        }
        System.out.println(respond);
    }
}
