package com.lx.javas.rpc.server;

import java.io.*;
import java.net.Socket;

/**
 * 服务线程
 * Created by lx on 2015/10/26.
 */
public class ServiceThread implements Runnable{

    //请求服务socket
    private Socket socket;
    //具体服务
    private IService service;


    public ServiceThread(Socket socket){
        this.socket = socket;
        this.service = ServiceFactory.newCommonService();
        System.out.println("Thread init ..." + super.toString());
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
            //打开输入输出流
            is = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            os = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));
            while(true){
                String param = reader.readLine();
                System.out.println("Thread receive :" + param);

                if(param.equals("close")){
                    System.out.println("Thread close ...");
                    break;
                }


                String result = doService(param);
                System.out.println("Thread respond :" + result);


                writer.write(result + "\n");       //输出到客户端
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭输入输出流
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


    /**
     * 服务方法
     * @param param
     * @return
     */
    private String doService(String param){
        return service.service(param);
    }
}
