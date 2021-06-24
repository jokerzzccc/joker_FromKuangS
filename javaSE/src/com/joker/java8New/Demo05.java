package com.joker.java8New;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.UUID;

/**
 * parallelStream() 并行流
 * 串行流（单线程）和并行流(多线程)的区别 ，并行流效率更高
 */
public class Demo05 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(UUID.randomUUID().toString());//生成随机字符串
        }
        //串行
        long start = System.currentTimeMillis();
        long count = arrayList.stream().sorted().count();
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }
}
