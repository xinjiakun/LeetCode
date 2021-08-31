package com.xin.volatileTest;

/**
 * @Classname Run
 * @Description volatile demo
 * @Date 2020/9/15 10:31
 * @Created by xinjiakun
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        RunThread thread = new RunThread();

        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);

        System.out.println("已经赋值为false");
    }
}
