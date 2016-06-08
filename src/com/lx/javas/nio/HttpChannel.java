package com.lx.javas.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 使用nio进行网络访问
 * Created by lx on 2016/6/8.
 */
public class HttpChannel {


    private SocketChannel channel;


    /**
     * 进行get请求
     * @param url
     * @throws IOException
     */
    public void doGet(String url) throws IOException {
        channel = SocketChannel.open();
        channel.connect(new InetSocketAddress(url,80));
        String header = getRequestHeader(url,"/");
        String result =
                withBuffer(header);
                //withCharStream(header);
        System.out.println(result);
        channel.close();
    }


    /**
     * 生成get请求头
     * @param host
     * @param path
     * @return
     */
    private String getRequestHeader(String host ,String path){
        String header = "GET " + path + " HTTP/1.1\r\n" +
                "Host :" + host + "\r\n" +
                //"Accept: text/html\r\n" +
                //"Accept-Language: zh-CN\r\n" +
                //"Accept-Encoding: gzip, deflate\r\n" +
                //"Connection: keep-alive\r\n" +
                "\r\n";
        return header;
    }


    /**
     * 使用buffer进行输入输出
     * @param header
     * @return
     * @throws IOException
     */
    private String withBuffer(String header) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(128);
        buffer.put(header.getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
        int length = channel.read(buffer);
        StringBuilder builder = new StringBuilder();
        while(length > 0){
            byte[] content = new byte[length];
            buffer.flip();
            buffer.get(content);
            builder.append(new String(content));
            System.out.println(new String(content));
            buffer.clear();
            length = channel.read(buffer);
        }
        return builder.toString();
    }


    /**
     * 使用字符流进行输入输出
     * @param header
     * @return
     * @throws IOException
     */
    private String withCharStream(String header) throws IOException {
        PrintWriter writer = new PrintWriter(Channels.newOutputStream(channel));
        Scanner reader = new Scanner(Channels.newInputStream(channel));
        writer.print(header);
        writer.flush();
        StringBuilder builder = new StringBuilder();
        while(reader.hasNext()){
            builder.append(reader.nextLine());
        }
        reader.close();
        writer.close();
        return builder.toString();
    }
}
