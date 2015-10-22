package com.lx.javas.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *方法代理
 * Created by lx on 2015/10/16.
 */
public class MethodProxy {


    /**
     *执行代理方法
     * @param retType  返回类型
     * @param paramType 参数类型列表
     * @param params  参数值
     * @param def  被代理类
     * @param name  执行方法名称
     */
    public Object runMethod(Class retType,Class[] paramType,Object[] params,Class def,String name){
        MethodType type = MethodType.methodType(retType,paramType);
        Object result = null;
        Object[] objs = new Object[params.length+1];
        for(int i=0;i<params.length;i++){
            objs[i+1] = params[i];
        }
        try {
            MethodHandle handle = MethodHandles.lookup().findVirtual(def,name,type);
            objs[0] = def.newInstance();
            result = handle.invokeWithArguments(objs);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
