package com.joker.threadSafeCollections;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 演示 CopyOnWriteArraySet
 *
 */
public class Demo03 {
    public static void main(String[] args) {
        //创建集合
        CopyOnWriteArraySet<String> arraySet = new CopyOnWriteArraySet<>();
        //添加元素
        arraySet.add("java");
        arraySet.add("python");
        arraySet.add("redis");
        arraySet.add("kotlin");
        arraySet.add("java");//不可以添加重复元素
        //打印
        System.out.println("元素个数"+arraySet.size());
        System.out.println(arraySet.toString());
    }
}
