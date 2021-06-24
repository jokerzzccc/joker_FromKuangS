package com.joker.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的创建
 *
 * @author joker_chen
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.1 创建固定大小的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //1，2 创建缓存线程池，线程个数，由任务个数决定
        ExecutorService executorService = Executors.newCachedThreadPool();
        //1.3 创建单线程池
//        Executors.newSingleThreadExecutor();
        //1.4 创建调度线程池
//        Executors.newScheduledThreadPool();


        //创建任务
        Runnable runnable = new Runnable() {
            private int ticket = 100;
            @Override
            public void run() {
                while (true){
                    if (ticket <= 0 ){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出 了"+ticket+"票");
                    ticket--;
                }
            }
        };
        //提交
        for (int i = 0; i < 5; i++) {//因为线程池里有4个线程
            executorService.submit(runnable);
        }

        //关闭线程池
        executorService.shutdown();//等待所有任务执行完毕后，然后关闭线程池，不接受新任务；推荐使用
//        executorService.shutdownNow();//会试图停止所有正在执行的任务，暂停处理正在等待的任务，并返回等待执行的任务列表
    }
}
