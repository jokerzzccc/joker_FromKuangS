package com.joker.threadSafeCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 使用多线程操作线程不安全集合
 * @author joker_chen
 */
public class Demo01 {
    public static void main(String[] args) {
//        //1 创建不安全的集合，ArrayList
//        ArrayList<String> arrayList = new ArrayList<>();//直接使用这个，就会出现并发问题
//        //1.1 使用Collections 中的线程安全方法 转成线程安全的集合
//        List<String> synchronizedList = Collections.synchronizedList(arrayList);
//        //1.2 使用 CopyOnWriteArrayList
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();


        for (int i = 0; i < 20; i++) {
            int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        strings.add(Thread.currentThread().getName() + "====="+temp +"=====" +j);
                        System.out.println(strings.toString());
                    }

                }
            }).start();
        }

    }
}
