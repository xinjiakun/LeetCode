package com.xin.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author 辛佳锟
 * @title: Myclient
 * @projectName LeetCode
 * @description: TODO
 * @date 2019/11/5 21:26
 */
public class Myclient {
    public static void main(String[] args) throws IOException {
        //连接服务器
        Socket socket = new Socket("127.0.0.1", 9999);
        InputStream inputStream = socket.getInputStream();
        //接收字节流
        byte[] bs = new byte[100];

//        inputStream.read(bs);
//        System.out.println("client接收到" + new String(bs));
        byte[] bytes = new byte[100];
        int len = 0;
        OutputStream fileout = new FileOutputStream("D:\\workspace.xml");
        while ((len = inputStream.read(bytes)) != -1) {
            fileout.write(bytes, 0, len);
        }
        //发送字节流
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("myclient".getBytes());

        fileout.close();
        inputStream.close();
//        outputStream.close();
        socket.close();
    }
}
