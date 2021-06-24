package com.joker.thread;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();

        joinThread.start();
        joinThread.join();
        //for 主线程，即默认 main() 是主线程
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "========"  + i);
            Thread.sleep(50);
        }
    }
}
