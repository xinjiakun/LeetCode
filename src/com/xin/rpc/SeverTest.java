package com.xin.rpc;

import java.io.IOException;

/**
 * @author 辛佳锟
 * @title: SeverTest
 * @projectName LeetCode
 * @description: 服务中心开启
 * @date 2019/11/7 23:16
 */
public class SeverTest {
    public static void main(String[] args) {
        //开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //开启服务
                Server server = new ServerCenter(9999);
                //将HelloService注册到服务中心
                server.register(HelloService.class, helloServiceImpl.class);
                try {
                    server.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
