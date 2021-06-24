package com.joker.thread;

/**
 * 生产者消费者
 * 容器类；
 *
 */
public class BreadContainer {
    //存放面包的数组
    private Bread[] cons = new Bread[6];
    //存放面包的位置，脚标
    private int index = 0;
    //放入面包，生产者
    public synchronized void input(Bread bread){
        while (index >= cons.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cons[index] = bread;
        System.out.println(Thread.currentThread().getName()+"生产了 "+bread.getId()+"");
        index++;
        this.notifyAll();

    }
    //取出面包，消费者
    public synchronized void output(Bread bread){
        while (index <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        index--;//因为index 代表面包数量，需要的是数组下标
        System.out.println(Thread.currentThread().getName()+"消费了 "+bread.getId()+"");
        cons[index] = null;

        this.notifyAll();

    }

}
