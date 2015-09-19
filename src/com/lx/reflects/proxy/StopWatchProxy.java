package com.lx.reflects.proxy;

import com.lx.interfaces.IStopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 秒表代理
 * Created by lx on 2015/9/5.
 */
public class StopWatchProxy implements InvocationHandler{

    //计时器接口
    private IStopWatch stopWatch;


    public StopWatchProxy(IStopWatch watch){
        this.stopWatch = watch;
    }


    public IStopWatch getProxy(){
        return (IStopWatch)Proxy.newProxyInstance(stopWatch.getClass().getClassLoader(),stopWatch.getClass().getInterfaces(),
            this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(stopWatch, args);
        long endTime = System.currentTimeMillis();
        System.out.println("Time is :" + (endTime-startTime)+" ms");
        return result;
    }
}
