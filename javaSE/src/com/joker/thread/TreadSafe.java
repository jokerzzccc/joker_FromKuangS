package com.joker.thread;

import java.util.Arrays;

/**
 * 线程安全问题
 */
public class TreadSafe {
    private static int index;
    public static void main(String[] args) throws InterruptedException {
        String[] str = new String[5];

        //创建两个操作
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                synchronized (str){//同步代码块
                    str[index] = "hello";
                    index++;
                }

            }
        };

        Runnable runnable2 = new Runnable() {

            @Override
            public void run() {
                synchronized (str){
                    str[index] = "world";
                    index++;
                }

            }
        };

        //创建两个线程对象
        Thread a = new Thread(runnable1, "a");

        Thread b = new Thread(runnable2, "b");

        a.start();
        b.start();

        a.join();//加入线程
        b.join();

        System.out.println(Arrays.toString(str));

    }
}
