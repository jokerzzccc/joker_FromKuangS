package com.joker.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection接口的使用：
 * 添加元素
 * 删除
 * 遍历
 * 判断
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        //添加
        collection.add("apple");
        collection.add("watermelon");
        collection.add("durian");

        System.out.println(collection.size());
        System.out.println(collection);

//        //删除
//        collection.remove("apple");
//        System.out.println(collection.size());
//        collection.clear();//清空

        //3. 遍历元素重点
        //3.1使用增强for
        for (Object object:collection
             ) {
            System.out.println(object);

        }
        //3.2使用迭代器（迭代器专门用来遍历集合的一种方式）
//        Iterator有三个方法
//        hasnext()判定是否有下一个元素
//        next()获取下一个元素
//        remove()删除当前元素
        System.out.println("===================3.2===========");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object str = iterator.next();
            System.out.println(str);
            //使用迭代器时，不可同时使用collection.remove(),但可以是使用iterator.remove();
            iterator.remove();
        }
        System.out.println(collection.size());

        //判断，是否包含某一个值
        System.out.println(collection.contains("apple"));
        //判空
        System.out.println(collection.isEmpty());


    }
}
