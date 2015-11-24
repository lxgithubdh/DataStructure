package com.lx.javas.runtime;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义classloader
 * Created by lx on 2015/11/13.
 */
public class CustomClassLoader extends ClassLoader{

    //类路径
    private String path;


    public CustomClassLoader(String path){
        super();
        this.path = path;
    }


    /**
     * 推荐方式
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        return defineClass(name,data,0,data.length);
    }


    /**
     * 可在JVM的不同类加载器中保留具有相同全限定名的类，不符合双亲委派模型
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class cls = null;
        try{
            cls = findLoadedClass(name);
            if(null!=cls){
               return cls;
            }
            byte[] data = loadClassData(name);
            if(null!=data&&data.length>0){
                cls = defineClass(name,data,0,data.length);
            }
            if(null==cls){
                cls = findSystemClass(name);
            }
            if(resolve&&null!=cls){
                resolveClass(cls);
            }
        }catch (Exception e){
            throw new RuntimeException("load error");
        }
        return cls;
    }

    /**
     * 加载类数据
     * @param name
     * @return
     */
    private byte[] loadClassData(String name){
        byte[] data = null;
        InputStream in = null;
        ByteArrayOutputStream os = null;
        try {
            name = name.replace(".","\\");
            in = new FileInputStream(new File(path+name+".class"));
            os = new ByteArrayOutputStream();
            int count = 0;
            while(-1!=(count=in.read())){
                os.write(count);
            }
            data = os.toByteArray();
        }catch (Exception e){
            throw new RuntimeException("类加载错误");
        }finally {
            try {
                in.close();
                os.close();
            }catch (Exception e){
                throw new RuntimeException("文件关闭失败");
            }
        }
        return data;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
