package com.xin.socket;


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
public class SeverFile {
    public static void main(String[] args) throws IOException {
        //定义服务端端口号
        ServerSocket sever = new ServerSocket(9999);
        //监听是否有客户端连接  并用socket获取
        Socket socket = sever.accept();
        System.out.println("客户端连接成功");

        //发送字符串 hello
        OutputStream outputStream = socket.getOutputStream();
        //发送本地文件
        File file = new File("D:\\projects\\workspace.xml");
        InputStream is = new FileInputStream(file);
        byte[] filebytes = new byte[100];
        int len = 0;
        while ((len = is.read(filebytes)) != -1) {
            outputStream.write(filebytes, 0, len);
        }

        is.close();
        sever.close();
        socket.close();
        outputStream.close();
    }
}