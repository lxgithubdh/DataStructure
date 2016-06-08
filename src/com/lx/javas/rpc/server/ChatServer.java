package com.lx.javas.rpc.server;

import com.lx.common.constant.Constant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 代理服务器
 * Created by lx on 2015/10/26.
 */
public class ChatServer {


    //服务器socket
    private ServerSocket server;
    //线程池
    private ThreadPool pool;
    //聊天室
    private ChatRoom room;


    public ChatServer(){
        pool = new ThreadPool();
        room = new ChatRoom();
        init();
    }


    /**
     * 打开服务
     */
    public void startService(){
        while(true){
            Member member = null;
            try {
                Socket socket = server.accept();  //获取连接的socket
                System.out.println("Server accept " +
                        socket.getInetAddress()+":"+socket.getPort());
                member = new Member(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            member.registerRoom(room);
            pool.execute(member);
        }
    }


    /**
     * 初始化方法
     */
    private void init(){
        try {
            server = new ServerSocket(Constant.SERVER_PORT);
            System.out.println("Server start ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
