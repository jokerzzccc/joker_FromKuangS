package com.joker.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 的使用 重入锁
 *
 */
public class MyList {
    private Lock lock = new ReentrantLock();
    private String[] strings = {"I","love","","",""};
    private int count = 2;
    public  void add(String value){
        lock.lock();
        try {
            strings[count] = value;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "添加了" + value );
    }

    public String[] getStr(){
        return strings;
    }

}
