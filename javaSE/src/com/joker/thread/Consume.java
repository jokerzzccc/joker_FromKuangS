package com.joker.thread;

/**
 * 消费者
 */
public class Consume implements Runnable{
    private BreadContainer con;
    public  Consume(BreadContainer breadContainer){
        super();
        this.con = breadContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            con.output(new Bread(i,Thread.currentThread().getName()));
        }

    }
}
