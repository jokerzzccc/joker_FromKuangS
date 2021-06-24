package com.joker.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 的使用
 */
public class Ticket  implements Runnable{
    private int ticket  = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (ticket <= 0){
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "卖了第" + ticket +"票");
                ticket--;
            }finally {
                lock.unlock();
            }
        }
    }
}
