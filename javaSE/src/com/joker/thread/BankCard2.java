package com.joker.thread;

/**
 * 线程通信
 * 实现：存一笔，取一笔
 *
 */
public class BankCard2 {
    //余额
    private double money;
    //标记
    private boolean flag = false;//flag 为 true ，表示可以取钱，为false 可以存钱
//存钱
    public synchronized void sale(double m){//锁this,即当前对象

        if (flag){//
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        money += m;
        System.out.println(Thread.currentThread().getName() + "存---了1000，余额为："+money);
        //修改标记
        flag = true;
        //唤醒取钱线程
        this.notifyAll();
    }

    //取钱
    public synchronized void take(double m){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        money -= m;
        System.out.println(Thread.currentThread().getName() + "取---了1000，余额为："+money);
        //修改标记
        flag = false;

        //唤醒存钱线程
        this.notifyAll();
    }
}
