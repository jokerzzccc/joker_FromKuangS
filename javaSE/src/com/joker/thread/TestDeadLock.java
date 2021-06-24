package com.joker.thread;

/**
 * 死锁案例：两个人，两个筷子
 */
public class TestDeadLock {
    public static void main(String[] args) {

        Runnable boy = new Runnable() {
            @Override
            public void run() {
                synchronized (MyLock.a){
                    System.out.println("boy拿到了a筷子");
                }
                synchronized (MyLock.b){
                    System.out.println("boy拿到了b筷子");
                    System.out.println("boy可以吃东西了");
                }
            }
        };

        Runnable girl = new Runnable() {
            @Override
            public void run() {
                synchronized (MyLock.b){
                    System.out.println("girl拿到了b筷子");
                }
                synchronized (MyLock.a){
                    System.out.println("girl拿到了a筷子");
                    System.out.println("girl可以吃东西了");
                }
            }
        };

        new Thread(boy,"boy").start();
        try {
            Thread.sleep(100);//线程休眠，让男孩先吃，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(girl,"girl").start();
    }
}
