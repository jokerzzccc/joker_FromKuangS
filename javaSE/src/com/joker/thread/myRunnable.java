package com.joker.thread;

/**
 * 创建线程方式2：实现 Runnable 接口，重写 run() 方法，执行线程需要丢入 Runnable 接口实现类，调用 start() 方法
 */
public class myRunnable implements Runnable{
    @Override
    public void run() {
        //run() 方法线程载体
        for (int i = 0; i < 10; i++) {
            System.out.println("支----线程" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建 Runnable 接口的实现类对象
        myRunnable myRunnable = new myRunnable();
        //创建一个线程对象,通过线程对象来开启我们的线程，这叫代理
        new Thread(myRunnable).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("主线程" + i);
        }
    }
}
