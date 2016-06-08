package com.lx.javas.rpc.server;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室
 * Created by lx on 2016/4/26.
 */
public class ChatRoom{


    //成员列表
    private List<OnReceiveMessage> members;


    public ChatRoom(int num){
        members = new ArrayList<>(num);
    }


    public ChatRoom(){
        this(8);
    }


    public void receive(String msg){
        System.out.println("ChatRoom receive : " + msg);
        for (OnReceiveMessage mem:members) {
            mem.send(msg);
        }
    }


    /**
     * 注册成员
     * @param member
     */
    public void register(OnReceiveMessage member){
        members.add(member);
    }


    /**
     * 取消注册
     * @param member
     */
    public void unregister(OnReceiveMessage member){
        members.remove(member);
    }
}
