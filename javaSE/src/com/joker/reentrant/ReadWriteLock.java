package com.joker.reentrant;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock 读写锁 的使用
 *
 * @author joker_chen
 */
public class ReadWriteLock {
    private ReentrantReadWriteLock rrl = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rrl.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rrl.writeLock();
//    private ReentrantLock lock = new ReentrantLock();//互斥锁,如果不用读写锁，使用互斥锁，就是都互斥，运行时间明显增加
    private String value = "java";

    //读取
    public String getValue(){
        readLock.lock();
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取了"+this.value);
            return this.value;
        }finally {
            readLock.unlock();
        }
    }
    //写入
    public void setValue (String value){
        writeLock.lock();
        try{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "写入了" + value);
            this.value = value;
        }finally {
            writeLock.unlock();
        }
    }
}
