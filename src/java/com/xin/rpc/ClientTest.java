package com.xin.rpc;

import java.net.InetSocketAddress;

/**
 * @author 辛佳锟
 * @title: ClientTest
 * @projectName LeetCode
 * @description: 客户端开启
 * @date 2019/11/7 23:24
 */
public class ClientTest {
    public static void main(String[] args) {
        try {
            com.xin.rpc.HelloService service = com.xin.rpc.Client.getRemoteProxyObj(Class.forName("com.xin.rpc.HelloService"),
                    new InetSocketAddress("127.0.0.1", 9999));
            System.out.println(service.sayHi("xinjiakun"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
