package com.xin.singleton;

/**
 * @Classname DoubleSyncSingeton
 * @Description 双重锁检验
 * @Date 2020/9/16 11:54
 * @Created by xinjiakun
 */
public class DoubleSyncSingeton {
    private static volatile DoubleSyncSingeton singleton;
    private DoubleSyncSingeton() {}
    public static DoubleSyncSingeton getInstance() {
        if(singleton == null) {
            synchronized (DoubleSyncSingeton.class) {
                if(singleton == null) {
                    singleton = new DoubleSyncSingeton();
                }
            }
        }
        return singleton;
    }
}
