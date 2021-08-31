package com.xin.volatileTest;

/**
 * @Classname AtomicTest
 * @Description 原子性demo（自增操作是不具备原子性）
 * @Date 2020/9/15 12:35
 * @Created by xinjiakun
 */
public class AtomicTest {
    public volatile int inc = 0;

    public void increase() {
        System.out.println("执行++");
        inc++;
    }

    public int getInc() {
        return inc;
    }

    public static void main(String[] args) {
        final AtomicTest test = new AtomicTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    System.out.println("threadName:" + this.getName());
                    for (int j = 0; j < 10000; j++)
                        test.increase();
                }

                ;
            }.start();
        }
        while (Thread.activeCount() > 2)//保证前面的线程都执行完
            System.out.println("inc");
            Thread.yield();
        System.out.println("inc:" + test.inc);
    }
}
