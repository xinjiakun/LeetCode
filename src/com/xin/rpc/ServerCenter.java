package com.xin.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 辛佳锟
 * @title: ServerCenter
 * @projectName LeetCode
 * @description: 服务中心具体实现
 * @date 2019/11/6 21:38
 */
public class ServerCenter implements Server {

    //服务端所有供客户端访问的接口注册到map中
    private static HashMap<String, Class> serviceRegiser = new HashMap<>();
    //服务端口号
    private static int port = 9999;
    //并发处理客户端访问  每来一次访问 从线程池取一个线程
    //Runtime.getRuntime().availableProcessors() 获取处理器个数 生成池中线程数
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //标识服务是否开启
    private static boolean isRunning = false;

    public ServerCenter(int port) {
        this.port = port;
    }

    @Override
    public void start() throws IOException{
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("start sever");
        isRunning = true;
        //多任务处理
        while (true) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ObjectOutputStream outputStream = null;
                    ObjectInputStream inputStream = null;
                    try {
                        //开启服务

                        Socket socket = serverSocket.accept();//等待客户端连接

                        //接收对象流  按序
                        inputStream = new ObjectInputStream(socket.getInputStream());
                        String serviceName = inputStream.readUTF();
                        String methodName = inputStream.readUTF();
                        Class[] parameter = (Class[]) inputStream.readObject();
                        Object[] arguments = (Object[]) inputStream.readObject();

                        //根据请求 到接口注册表中找到具体的接口
                        Class serviceClass = serviceRegiser.get(serviceName);
                        //得到方法对象   参数 ：方法名 方法参数类型
                        Method method = serviceClass.getMethod(methodName, parameter);
                        //反射调用方法  参数：对象  参数
                        Object result = method.invoke(serviceClass.newInstance(), arguments);
                        //向客户端将方法执行完毕的返回值传回客户端
                        outputStream = new ObjectOutputStream(socket.getOutputStream());
                        outputStream.writeObject(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (outputStream != null) { outputStream.close(); }
                            if (inputStream != null) { inputStream.close(); }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });


        }
    }
    @Override
    //关闭服务
    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    @Override
    public void register(Class service, Class serviceImpl) {
        serviceRegiser.put(service.getName(), serviceImpl);
    }
}
