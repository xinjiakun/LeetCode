package com.xin.socket;


import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 辛佳锟
 * @title: SeverSocket
 * @projectName LeetCode
 * @description: TODO
 * @date 2019/11/5 21:17
 */
public class MySever {
    public static void main(String[] args) throws IOException {
        //定义服务端端口号
        ServerSocket sever = new ServerSocket(9999);
        //监听是否有客户端连接  并用socket获取
        Socket socket = sever.accept();
        System.out.println("客户端连接成功");

        //发送字符串 hello
        OutputStream outputStream = socket.getOutputStream();
        byte[] bs = new byte[100];
        String info = "hello";
        outputStream.write(info.getBytes());
        //获取客户端发来的流  保存到字节流bs
        InputStream inputStream = socket.getInputStream();
        inputStream.read(bs);
        System.out.println(new String(bs));


        sever.close();
        socket.close();
        inputStream.close();
        outputStream.close();
    }
}
