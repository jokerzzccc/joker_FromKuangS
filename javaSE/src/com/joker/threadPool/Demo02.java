package com.joker.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Collable 接口的使用
 *
 *功能需求：求1-100的和
 * @author joker_chen
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
//创建 Callable 对象
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "开始计算");
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum +=i;
                    Thread.sleep(100);
                }
                return sum;
            }
        };
//把 Callable 对象转换成可执行任务，
        //因为Thread里没有 Callable 这个类型的参数
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callable);
//创建线程
        Thread thread = new Thread(integerFutureTask);

        thread.start();
//获取结果get()
        Integer sum = integerFutureTask.get();//等待call 执行完毕，才会返回结果
        System.out.println("计算结果" + sum);
    }
}
