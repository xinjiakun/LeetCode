package com.xin.volatileTest;
/**
 * @Classname RunThread
 * @Description 有序性demo
 * @Date 2020/9/15 10:28
 * @Created by xinjiakun
 */
public class Reorder {
    static int a, b, x, y;

    public static void main(String[] args) {

        long time = 0;
        while (true) {
            time++;
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (Exception e) {
            }
            if (x == 0 && y == 0) {
                break;
            }
        }
        System.out.println("time=" + time + ",x=" + x + ",y=" + y);
    }
}