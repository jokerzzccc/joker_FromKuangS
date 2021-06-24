package com.joker.threadSafeCollections;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用多线程操作 CopyOnWriteArrayList
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建了5个线程的线程池，每个线程池都分配了5个任务，每个任务都是向集合添加10个元素
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        arrayList.add(Thread.currentThread().getName() + "---" + new Random().nextInt(1000));

                    }
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("元素个数：" + arrayList.size());
        for (String string :
                arrayList) {
            System.out.println(string);
        }
    }
}
