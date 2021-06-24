package com.joker.thread;

/**
 * 使用 Runnable 实现类，来完成多个线程操作同一个对象
 * 案例：买火车票
 * 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
 */
public class testThread4 implements Runnable {
    //票数
    private int ticketNums = 10;


    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }

            try {
                Thread.sleep(1000);//模拟延时
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
            System.out.println(Thread.currentThread().getName()+"拿到了第" + ticketNums +"张票");
            ticketNums--;
        }

    }

    public static void main(String[] args) {
        testThread4 ticket = new testThread4();

        new Thread(ticket,"我").start();
        new Thread(ticket,"爱").start();
        new Thread(ticket,"你").start();

    }
}
