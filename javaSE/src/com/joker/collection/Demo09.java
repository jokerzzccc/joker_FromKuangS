package com.joker.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet
 * 存储结构: (数组+链表+红黑树)
 */
public class Demo09 {
    public static void main(String[] args) {
        HashSet<Person> persons =  new HashSet<>();

        Person person1 = new Person("apple", 10);
        Person person2 = new Person("orange", 20);
        Person person3 = new Person("durian", 30);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
//        persons.add(person1);//重复，添加不了

        persons.add(new Person("apple",10));//是可以添加的，如果要改成不可以添加，就要重写 equals()和hashCode()
        System.out.println("sum: " + persons.size());
        System.out.println(persons.toString());

        //删除
//        persons.remove(person1);

        //遍历
        //foreach
        for (Person person :
                persons) {
            System.out.println(person);
        }

        //Iterator
        System.out.println("====Iterator");
        Iterator<Person> iterator =persons.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //判断
        System.out.println(persons.contains(person1));


    }
}
