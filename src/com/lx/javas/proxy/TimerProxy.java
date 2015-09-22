package com.lx.javas.proxy;

import com.lx.javas.annotation.Timer;
import com.lx.common.interfaces.ISort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 计时器代理
 * Created by lx on 2015/9/20.
 */
public class TimerProxy implements InvocationHandler{


    //排序接口
    private ISort sort;


    public TimerProxy(ISort sort){
        this.sort = sort;
    }


    /**
     * 获取代理类
     * @return
     */
    public ISort getTimerProxy(){
        Class cls = sort.getClass();
        return (ISort) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(sort,args);
        if(method.isAnnotationPresent(Timer.class)){
            long end = System.currentTimeMillis();
            System.out.println("Time is :"+(end-start)+"ms.");
        }
        return result;
    }
}
