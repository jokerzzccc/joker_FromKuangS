package com.joker.threadSafeCollections;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列
 * 案例：使用阻塞队列实现生产者和消费者
 */
public class Demo07 {
    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(6);

        Thread produce = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        queue.put(i);//一次最多只能放入6个面包
                        //打印并没有同步，所以，打印可能会出现问题
                        System.out.println(Thread.currentThread().getName() + "生产了" + i + "号面包");//这个并没有同步，所以，打印可能会出现问题
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"monster");

        Thread consume = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        Integer num = queue.take();//一次最多只能放入6个面包
                        //打印并没有同步，所以，打印可能会出现问题
                        System.out.println(Thread.currentThread().getName() + "消费了" + i + "号面包");//这个并没有同步，所以，打印可能会出现问题
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"joker");

        produce.start();
        consume.start();
    }
}
