package com.lx.javas.rpc.client;

/**
 * socket接口
 * Created by Administrator on 2015/10/26.
 */
public interface ISocketConnect {


    /**
     * 打开连接
     */
    void open() throws Exception;


    /**
     * 调用远程方法
     * @param param
     * @return
     */
    String call(String param) throws Exception;


    /**
     * 关闭连接
     */
    void close() throws Exception;
}
