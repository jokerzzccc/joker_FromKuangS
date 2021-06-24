package com.joker.reentrant;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMyList {
    public static void main(String[] args) throws InterruptedException {
        MyList myList = new MyList();
        ReentrantLock reentrantLock = new ReentrantLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myList.add("java");

            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                myList.add("python");

            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread2.start();

        thread1.join();//保证线程执行完，才会执行主线程
        thread2.join();

        System.out.println(Arrays.toString(myList.getStr()));
    }
}
