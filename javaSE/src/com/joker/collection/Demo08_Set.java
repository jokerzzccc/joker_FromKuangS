package com.joker.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试Set接口的常用
 * @author joker_chen
 *
 */
public class Demo08_Set {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        //1.添加数据
        set.add("zhao");
        set.add("qian");
        set.add("sun");
        System.out.println("数据个数："+set.size());
        System.out.println(set.toString());//无序输出
        //2.删除数据
        /*
         * set.remove("zhao");
         * System.out.println(set.toString());
         */
        //3.遍历【重点】
        //3.1 使用增强for
        for (String string : set) {
            System.out.println(string);
        }
        //3.2 使用迭代器
        Iterator<String> iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //4.判断
        System.out.println(set.contains("qian"));
        System.out.println(set.isEmpty());
    }

    }

