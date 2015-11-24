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


    public static Object getProxy(Class cls){
        return Proxy.newProxyInstance(cls.getClassLoader(),
                new Class[]{cls}, new ProxyClient());
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Socket socket = new Socket("127.0.0.1", Constant.SERVER_PORT);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        OutputStreamWriter writer = new OutputStreamWriter(os);
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<args.length;i++){
            builder.append(args[i]).append("\n");
        }
        writer.write(builder.toString());
        writer.flush();
        builder.delete(0, builder.length());
        String tmp = reader.readLine();
        while(null!=tmp){
            builder.append(tmp);
            tmp = reader.readLine();
        }
        is.close();
        os.close();
        reader.close();
        socket.close();
        result = builder.toString();
        return result;
    }
}
