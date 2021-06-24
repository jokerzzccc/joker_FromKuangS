package com.joker.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayList的使用
 * 存储结构：数组
 *
 */

public class Demo05 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>();
         //1.添加
        Student stu1 = new Student("zhangsan", 20);
        Student stu2 = new Student("lisi", 30);
        Student stu3 = new Student("wangwu", 40);

        arrayList.add(stu1);
        arrayList.add(stu2);
        arrayList.add(stu3);

        System.out.println(arrayList.size());
//        //2. 删除
//        arrayList.remove(stu1);
//        arrayList.remove(new Student("zhangsan",20));//是不可以直接实现的，要重写Student类的equals()方法。
//        System.out.println("after remove: "+arrayList.size());

        //3遍历元素
        //3.1使用迭代器
        Iterator iterator=arrayList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //3.2使用列表迭代器
        ListIterator listIterator=arrayList.listIterator();
        //从前往后遍历
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        //从后往前遍历
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        //4.判断
        System.out.println(arrayList.isEmpty());
        //System.out.println(arrayList.contains(new Student("何", 22)));
        //注：与上文相同的问题。
        //5.查找
        System.out.println(arrayList.indexOf(stu1));

    }
}
