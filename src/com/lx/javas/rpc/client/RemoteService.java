package com.lx.javas.rpc.client;

/**
 * 远程过程调用接口
 * Created by lx on 2016/4/26.
 */
public interface RemoteService {


    /**
     * 远程调用方法
     * @param param
     * @return
     * @throws Exception
     */
    String call(String param) throws Exception;
}
