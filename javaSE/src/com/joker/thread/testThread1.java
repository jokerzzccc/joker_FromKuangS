package com.joker.thread;

/**
 * 创建线程方式一：继承 Thread 类，调用start() 方法
 * 注：线程开启不一定立即执行，由 cpu 安排调度
 *
 * @author joker_chen
 */
public class testThread1 extends Thread{
    @Override
    public void run() {
        //run() 方法线程载体
        for (int i = 0; i < 10; i++) {
            System.out.println("子----线程" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程对象
        testThread1 testThread1 = new testThread1();
        //调用 start() 开启线程
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("主线程" + i);
        }
    }
}
