package com.lx.common.util;

import com.lx.javas.annotation.Inject;

import java.lang.reflect.Field;

/**
 * 通过类名实例化对象
 * Created by lx on 2016/4/19.
 */
public class BeanFactory {

    public static Object createInstance(Class<?> cls) throws Exception{
        Object obj = cls.newInstance();
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields){
            Inject inject = field.getAnnotation(Inject.class);
            if(inject!=null){
                field.setAccessible(true);
                field.set(obj,inject.value());
            }
        }
        return obj;
    }
}
