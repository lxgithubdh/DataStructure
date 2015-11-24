package com.lx.javas.rpc.server;

import java.io.*;
import java.net.Socket;

/**
 * 服务线程
 * Created by lx on 2015/10/26.
 */
public class ServiceThread extends Thread{

    //被服务socket
    private Socket socket;


    public ServiceThread(Socket s){
        this.socket = s;
    }


    @Override
    public void run(){
        if(null==socket){
            return;
        }
        InputStream is = null;
        BufferedReader reader = null;
        OutputStream os = null;
        BufferedWriter writer = null;
        try {
            is = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String param = reader.readLine();
            String result = doService(param);
            os = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(result);       //输出到客户端
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(null!=is){
                    is.close();
                }
                if(null!=reader){
                    reader.close();
                }
                if(null!=os){
                    os.close();
                }
                if(null!=writer){
                    writer.close();
                }
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    private String doService(String param){
        return "Hello " + param;
    }
}
