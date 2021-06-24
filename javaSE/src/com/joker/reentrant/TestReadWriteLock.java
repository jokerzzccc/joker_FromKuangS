package com.joker.reentrant;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ReentrantReadWriteLock
 *
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Runnable read = new Runnable() {
            @Override
            public void run() {
                readWriteLock.getValue();
            }
        };
        Runnable write = new Runnable() {
            @Override
            public void run() {
                readWriteLock.setValue("joker"+new Random().nextInt(100));
            }
        };
        long startTime = System.currentTimeMillis();
        //分配18个读取任务
        for (int i = 0; i < 18; i++) {
            executorService.submit(read);
        }
        //分配两个写入任务
        for (int i = 0; i < 2; i++) {
            executorService.submit(write);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){//isTerminated() 返回值是true 则代表所有任务已经结束
            //空转
        }
        long endTime = System.currentTimeMillis();

        System.out.println("运行时间" + (endTime - startTime));

    }
}
