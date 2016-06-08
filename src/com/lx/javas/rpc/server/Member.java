package com.lx.javas.rpc.server;

import java.io.*;
import java.net.Socket;

/**
 * 系统用户
 * Created by lx on 2016/4/26.
 */
public class Member implements Runnable,OnReceiveMessage{


    private BufferedReader reader;
    private BufferedWriter writer;
    private ChatRoom room;
    private Socket socket;


    public Member(Socket s) throws IOException {
        this.socket = s;
        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
    }


    public void registerRoom(ChatRoom room){
        this.room = room;
        room.register(this);
    }


    @Override
    public void run() {
        while(true){
            String msg = null;
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(msg.equals("close")){
                break;
            }
            room.receive(msg);
        }
        close();
    }


    /**
     * 返回消息
     * @param msg
     */
    private void respond(String msg){
        try {
            writer.write(msg + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void send(String msg) {
        respond(msg);
    }


    public void close(){
        if(null!=room){
            room.unregister(this);
        }
        try {
            socket.close();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
