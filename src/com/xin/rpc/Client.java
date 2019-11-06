package com.xin.rpc;

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
    public static <T> T getRemoteProxyObj(Class serviceInterface, InetSocketAddress address){
         return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface}, new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 Socket socket = new Socket();
                 socket.connect(address);
                 ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                 outputStream.writeUTF(serviceInterface.getName());
                 outputStream.writeUTF(method.getName());

                 return null;
             }
         });
    }
}
