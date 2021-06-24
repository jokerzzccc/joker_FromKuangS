package com.joker.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List子接口的使用，
 * 1. 添加
 * 2. 删除
 * 3. 遍历
 * 4. 判断
 * 5. 获取位置
 */
public class Demo03 {
    public static void main(String[] args) {
        List list = new ArrayList();
        //1添加
        list.add("apple");
        list.add("orange");

        System.out.println(list.size());
        System.out.println(list.toString());

        //2删除
//        list.remove("apple");
//        list.remove(0);

        //3.遍历
        //3.1 使用for
        System.out.println("=====3.1 for 遍历==========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //3.2 使用for-each
        System.out.println("=======3.2=========");
        for (Object object:list) {
            System.out.println(object);
        }
        //3.3 使用Iterator
        System.out.println("====3.3=====");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //3.4使用列表迭代器 listIterator,和Iterator的区别：ListIterator可以向前或向后遍历，添加，删除，修改元素(重点)
        System.out.println("==========3.4 ListIterator==========");
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.nextIndex() +":" + listIterator.next());
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previousIndex() +":" + listIterator.previous());
        }
        //4 判断
        System.out.println(list.contains("apple"));//是否包含
        System.out.println(list.isEmpty());
        //5 获取位置
        System.out.println(list.indexOf("apple"));
    }
}
