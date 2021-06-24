package com.joker.collection;

import java.util.TreeSet;

/**
 * TreeSet
 * 存储结构：红黑树
 * 要求：元素类型必须实现 Comparable接口，compareTo()方法返回值是0，则认为是重复元素，不可添加。
 */
public class Demo10_TreeSet {
    public static void main(String[] args) {
        //创建集合
        TreeSet<Person> persons = new TreeSet<>();

        Person person1 = new Person("apple", 10);
        Person person2 = new Person("orange", 20);
        Person person3 = new Person("durian", 30);

        //添加
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
//要重写compareTo(),确定比较对象
        System.out.println("sum: "+persons.size());
        System.out.println(persons.toString());

//        //2.删除元素
//        persons.remove(p1);
//        persons.remove(new Person("apple", 10));//因为重写了compareTo()方法所以可是这样写
//        System.out.println(persons.toString());
        //3.遍历（略）
        //4.判断
        System.out.println(persons.contains(new Person("apple", 10)));


    }
}
