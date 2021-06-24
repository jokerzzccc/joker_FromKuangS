package com.joker.thread;

public class Ticket extends Thread{
    private  int ticket = 100;
//    private Object obj = new Object();//1 自己创建锁

    public Ticket(){
    }

    public Ticket(String name){
            super(name);

    }

//    @Override
//    public void run() {
//        while (true){
//            synchronized (this){//2 用this 当锁，便是当前对象，即 ticket
//                if (ticket > 0){
//                    ticket--;
//                    System.out.println(Thread.currentThread().getName() + "卖出了一张票，还剩" +ticket);
//
//                }else {
//                    break;
//                }
//            }
//        }
//    }

//同步方法的的使用
    @Override
    public void run() {
        while (true){
            if (!sale()){
                break;
            }
        }
    }
//方法不是静态的时候，就是 锁this,谁调用，就锁谁
//方法钱加了静态 static 的时候，public static synchronized boolean sale() ,就是锁 类对象，就相当于在同步代码块里写 Ticket.class
    public synchronized boolean sale(){
        if (ticket <= 0) {
            return false;
        }

        System.out.println(Thread.currentThread().getName() + "卖出了一张票，还剩" + ticket);
        ticket--;

        return true;
    }
}
