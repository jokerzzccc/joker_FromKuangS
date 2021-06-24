package com.joker.threadPool;

import java.util.concurrent.*;

/**
 * Future 接口
 * 案例：使用两个线程，并发计算1-50，51-100的和，再进行汇总统计
 *
 * @author joker_chen
 */
public class Demo04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool =  Executors.newFixedThreadPool(2);
        
       Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                int sum = 0;
                for (int i = 0; i <= 50; i++) {
                    sum +=i;
                }
                System.out.println("1-50计算完毕");

                return sum;
            }
        });

        Future<Integer> future1 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                int sum = 0;
                for (int i = 51; i <= 100; i++) {
                    sum +=i;
                }
                System.out.println("51-100计算完毕");

                return sum;
            }
        });

        int sum = future.get() + future1.get();
        System.out.println(sum);

        pool.shutdown();
    }
}
