package com.lx.javas.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 服务器远程调用类
 * Created by lx on 2016/6/7.
 */
public class RemoteCallImpl implements IRemoteCall{


    public RemoteCallImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public String call(String msg) throws RemoteException {
        return "Hello " + msg + " !";
    }
}
