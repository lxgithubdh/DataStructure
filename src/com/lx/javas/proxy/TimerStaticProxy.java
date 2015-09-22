package com.lx.javas.proxy;

import com.lx.common.interfaces.ISort;
import com.lx.javas.annotation.Timer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 计时器静态代理
 * Created by lx on 2015/9/20.
 */
public class TimerStaticProxy implements ISort{


    //排序接口
    private Class cls;
    //被代理对象
    private Object obj;


    /**
     * 构造函数
     * @param cls 实现ISort接口
     */
    public TimerStaticProxy(Class cls,Class[] types,Object[] objs){
        this.cls = cls;
        try {
            Constructor constructor = cls.getConstructor(types);
            obj = constructor.newInstance(objs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int[] sort(int[] arr) {
        Method sort = null;
        try {
            sort = cls.getMethod("sort", int[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        int[] result = null;
        try {
            result = (int[])sort.invoke(obj,(Object)arr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(sort.isAnnotationPresent(Timer.class)){
            long end = System.currentTimeMillis();
            System.out.println("Time is "+(end-start)+"ms.");
        }
        return result;
    }
}
