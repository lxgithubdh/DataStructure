package com.lx.javas.rpc.server;

/**
 * 服务工厂
 * Created by lx on 2016/4/26.
 */
public class ServiceFactory {

    public static IService newCommonService(){
        return new CommonService();
    }
}
