package com.lx.javas.rpc.client;

import com.lx.common.constant.Constant;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2016/4/27.
 */
public class ChatClient implements ISocketConnect{


    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean flag = true;



    @Override
    public void open() throws Exception {
        socket = new Socket("127.0.0.1", Constant.SERVER_PORT);
        reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream()));
        new ReceiveThread().start();
        System.out.println("Client socket open ...");
    }

    @Override
    public String call(String param) throws Exception {
        writer.write(param + "\n");
        writer.flush();
        return null;
    }

    @Override
    public void close() throws Exception {
        call("close");
        flag = false;
        reader.close();
        writer.close();
        socket.close();
        System.out.println("Client socket close ...");
    }


    class ReceiveThread extends Thread{
        @Override
        public void run() {
            try {
                String msg;
                while(flag){
                    msg = reader.readLine();
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
