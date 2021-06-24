package com.joker.collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector的使用
 * 重点注意枚举器Enumeration，其它都一样
 * @author joker_chen
 */
public class Demo06 {
    public static void main(String[] args) {
        Vector vector = new Vector();

        //1.添加数据
        vector.add("apple");
        vector.add("orange");
        vector.add("durian");
        System.out.println("元素个数："+vector.size());
        //2.删除数据
        /*
         * vector.remove(0);
         * vector.remove("apple");
         */
        //3.遍历
        //使用枚举器
        Enumeration enumeration=vector.elements();
        while (enumeration.hasMoreElements()) {
            String s = (String) enumeration.nextElement();
            System.out.println(s);
        }
        //4.判断
        System.out.println(vector.isEmpty());
        System.out.println(vector.contains("apple"));
        //5. Vector其他方法
        //firstElement()  lastElement()  ElementAt();
        }


    }

