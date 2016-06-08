package com.lx.javas.rpc.client;

import com.lx.common.constant.Constant;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 代理客户端
 * Created by lx on 2015/10/26.
 */
public class ProxyClient implements InvocationHandler{


    /**
     * 获取代理
     * @param cls 被代理接口
     * @return
     */
    public static Object getProxy(Class cls){
        return Proxy.newProxyInstance(cls.getClassLoader(),
                new Class[]{cls}, new ProxyClient());
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Socket socket = new Socket("127.0.0.1", Constant.SERVER_PORT);//连接服务器
        //获取输入输出流
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        //封装为缓冲字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        OutputStreamWriter writer = new OutputStreamWriter(os);
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<args.length;i++){
            builder.append(args[i]).append("\n");
        }
        //将参数发送到服务器端
        writer.write(builder.toString());
        writer.flush();
        //清空StringBuilder
        builder.delete(0, builder.length());
        //读取返回信息
        String tmp = reader.readLine();
        while(null!=tmp){
            builder.append(tmp);
            tmp = reader.readLine();
        }
        //关闭输入输出流
        is.close();
        os.close();
        reader.close();
        socket.close();
        result = builder.toString();
        //返回结果
        return result;
    }
}
