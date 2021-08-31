package com.xin.rpc;

import java.io.IOException;

//服务中心接口
public interface Server {
    public void start()throws IOException;

    public void stop();

    public void register(Class service, Class serviceImpl);
}
