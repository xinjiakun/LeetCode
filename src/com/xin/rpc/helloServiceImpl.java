package com.xin.rpc;

/**
 * @author 辛佳锟
 * @title: helloSeverImpl
 * @projectName LeetCode
 * @description: 服务提供实现类
 * @date 2019/11/6 21:33
 */
public class helloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "hi"+name;
    }
}
