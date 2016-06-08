package com.lx.javas.rpc.client;

import com.lx.common.constant.Constant;

import java.io.*;
import java.net.Socket;

/**
 * 普通客户端
 * Created by lx on 2016/4/19.
 */
public class CommonClient implements ISocketConnect {


    private Socket socket;


    @Override
    public void open() throws IOException{
        socket = new Socket("127.0.0.1", Constant.SERVER_PORT);
        System.out.println("Client socket open ...");
    }

    @Override
    public String call(String param) throws IOException{
        OutputStream os = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
        writer.write(param + "\n" + param + "\n\n");
        writer.flush();
        System.out.println("Client send : " + param);

        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String tmp = reader.readLine();
        System.out.println("Server send back : " + tmp);

        return tmp;
    }

    @Override
    public void close() throws IOException {
        call("close");
        socket.close();
        System.out.println("Client socket close ...");
    }
}
