package com.xin.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author 辛佳锟
 * @title: Client
 * @projectName LeetCode
 * @description: TODO
 * @date 2019/11/6 21:57
 */
public class Client {
    public static <T> T getRemoteProxyObj(Class serviceInterface, InetSocketAddress address) {
        //动态代理对象
        //参数 1 类加载器 2接口数组 3 InvocationHandler
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface}, new InvocationHandler() {
            @Override
            //proxy 代理对象  method 具体某个方法   args 参数列表
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket();
                ObjectOutputStream outputStream = null;
                ObjectInputStream inputStream = null;
                try {
                    socket.connect(address);

                    //对象序列化流发送socket
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    //字符串发送使用 writeUTF
                    //发送接口名 方法名
                    outputStream.writeUTF(serviceInterface.getName());
                    outputStream.writeUTF(method.getName());
                    //发送参数类型  方法参数
                    outputStream.writeObject(method.getParameterTypes());
                    outputStream.writeObject(args);

                    //接收服务端处理后的返回值
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    return inputStream.readObject();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                }
            }
        });
    }
}
