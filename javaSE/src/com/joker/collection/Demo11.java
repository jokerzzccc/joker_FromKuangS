package com.joker.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet集合的使用
 * Comparator:实现定制比较（比较器）
 * Comparable:可比较的
 * @author joker_chen
 *

 */
public class Demo11 {
    public static void main(String[] args) {
        //创建集合，并使用Comparator指定比较规则，可以不用实现Comparable接口;使用匿名内部类来实现
        TreeSet<Person> persons = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //先比年龄，后比名字
                int n1 = o1.getAge() - o2.getAge();
                int n2 = o1.getName().compareTo(o2.getName());
                return n1 == 0 ? n2:n1;
            }
        });

        Person person1 = new Person("apple", 10);
        Person person2 = new Person("orange", 20);
        Person person3 = new Person("durian", 30);
        Person person4 = new Person("egg", 30);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        System.out.println("sum: "+persons.size());
        System.out.println(persons.toString());


    }
}
