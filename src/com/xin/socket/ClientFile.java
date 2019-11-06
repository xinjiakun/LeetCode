package com.xin.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 辛佳锟
 * @title: Myclient
 * @projectName LeetCode
 * @description: TODO
 * @date 2019/11/5 21:26
 */
public class ClientFile {
    public static void main(String[] args) throws IOException {
        //连接服务器
        Socket socket = new Socket("127.0.0.1", 9999);
        InputStream inputStream = socket.getInputStream();
        //接收字节流


        byte[] bytes = new byte[100];
        int len = 0;
        OutputStream fileout = new FileOutputStream("D:\\workspace.xml");
        while ((len = inputStream.read(bytes)) != -1) {
            fileout.write(bytes, 0, len);
        }

        fileout.close();
        inputStream.close();
        socket.close();
    }
}