package com.xin.rpc;

/**
 * @author 辛佳锟
 * @title: helloSeverImpl
 * @projectName LeetCode
 * @description: TODO
 * @date 2019/11/6 21:33
 */
public class helloServiceImpl implements HelloService {
    @Override
    public void sayHi(String name) {
        System.out.println("hi"+name);
    }
}
