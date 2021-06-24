package com.joker.threadSafeCollections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Quene 接口的使用
 *
 * @author joker_chen
 */
public class Demo04 {
    public static void main(String[] args) {
        //创建队列，LinkedList() 不安全
        Queue<String> queue = new LinkedList<>();
        //2 入队
        queue.offer("apple");
        queue.offer("durian");
        queue.offer("orange");
        queue.offer("watermelon");
        queue.offer("grape");
        //3 出队
        System.out.println(queue.peek());//不会删除
        System.out.println("===========");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }
        System.out.println("出队完，队列元素个数"+queue.size());

    }
}
