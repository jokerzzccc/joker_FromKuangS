package com.joker.threadSafeCollections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 的使用
 *
 */
public class Demo08 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        //使用多线程添加数据
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        hashMap.put(Thread.currentThread().getName() + "--" + j,j + "");
                        System.out.println(hashMap);
                    }
                }
            }).start();
        }
    }
}
