package com.joker.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List的是使用（二）
 *
 */
public class Demo04 {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        //1.添加数字（自动装箱）
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("元素个数： "+list.size());
        System.out.println(list.toString());

        //删除,可以根据下标，或强制转换为对象。
//        list.remove((Object) 20);
//        System.out.println(list);

        //subList() 方法，含头不含尾
        List list_sub = list.subList(0,2);
        System.out.println(list_sub.toString());

    }
}
