package com.joker.threadPool;

import java.util.concurrent.*;

/**
 * 线程池与 Callable 结合使用
 * 计算1-100的和
 */
public class Demo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //提交任务；Future:表示将要执行完任务的结果
        Future<Integer> future =  executorService.submit(new Callable<Integer>() {//submit() 返回值是Future 类型的
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() +"开始计算");
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum +=i;
                }
                return sum;
            }
        });

        System.out.println(future.get());//等待任务执行完毕，即call() 里的执行完，才会返回值
        executorService.shutdown();
    }
}
