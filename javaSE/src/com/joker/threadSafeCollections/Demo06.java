package com.joker.threadSafeCollections;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * BlockingQueue 阻塞队列的使用
 *
 */
public class Demo06 {
    public static void main(String[] args) throws  Exception{
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        //添加元素
        queue.put("aaa");
        queue.put("bbb");
        queue.put("ccc");
        queue.put("ddd");
        queue.put("eee");
        System.out.println(
                "已经添加了5个元素"
        );
        //删除队头元素
        queue.take();
        queue.put("fff");
        System.out.println("已经添加了第6个元素");
        System.out.println(queue.toString());
    }
}
