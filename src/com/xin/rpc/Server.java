package com.xin.rpc;

//服务中心接口
public interface Server {
    public void start();

    public void stop();

    public void register(Class service, Class serviceImpl);
}
