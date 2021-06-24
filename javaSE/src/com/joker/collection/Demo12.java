package com.joker.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet案例
 * 要求:使用TreeSet集合，实现字符串按照长度进行排序
 * Comparator接口实现定制比较
 * @author joker_chen
 */
public class Demo12 {
    public static void main(String[] args) {
        TreeSet<String> stringTreeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int r1 = o1.length() - o2.length();
                int r2 = o1.compareTo(o2);//用原来的比较方式

                return r1 == 0 ? r2:r1;//先用长度比较，长度相同，则用原来的比较方式，
            }
        });

        stringTreeSet.add("zhao");
        stringTreeSet.add("qian");
        stringTreeSet.add("li");
        stringTreeSet.add("sun");
        stringTreeSet.add("zheng");
        stringTreeSet.add("kkkkkkkkk");

        System.out.println(stringTreeSet);

    }
}
