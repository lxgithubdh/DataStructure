package com.lx.javas.rpc.server;

/**
 * 普通服务
 * Created by lx on 2016/4/26.
 */
public class CommonService implements IService{


    @Override
    public String service(String param) {
        return "Hello " + param + " !";
    }
}
