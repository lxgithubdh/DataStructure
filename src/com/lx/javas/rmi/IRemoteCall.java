package com.lx.javas.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程过程调用接口
 * Created by lx on 2016/6/7.
 */
public interface IRemoteCall extends Remote{


    /**
     * 远程方法接口
     * @param msg
     * @return
     * @throws RemoteException
     */
    String call(String msg) throws RemoteException;
}