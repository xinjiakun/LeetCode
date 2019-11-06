package com.xin.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.List;

/**
 * @author 辛佳锟
 * @title: ServerCenter
 * @projectName LeetCode
 * @description: 服务中心具体实现
 * @date 2019/11/6 21:38
 */
public class ServerCenter implements Server {

    //服务端所有供客户端访问的接口注册到map中
    private HashMap<String, Class> serviceRegiser = new HashMap<>();
    private static int port = 9999;
    public ServerCenter(int port){
        this.port = port;
    }
    @Override
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void register(Class service, Class serviceImpl) {
        serviceRegiser.put(service.getName(), serviceImpl);
    }
}
