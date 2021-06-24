package com.joker.collection;

import com.joker.classused.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * LinkedList的使用，
 * 存储结构：双向链表
 * @author joker_chen
 */
public class Demo07 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<>();
        //
        Student stu1 = new Student("zhao", 10);
        Student stu2 = new Student("qian", 20);
        Student stu3 = new Student("sun", 30);
        //添加
        linkedList.add(stu1);
        linkedList.add(stu2);
        linkedList.add(stu3);

        System.out.println(linkedList.size());

        //删除
//        linkedList.remove(stu1);
//        System.out.println(linkedList.toString());
//        linkedList.clear();

        //遍历
        //3.1 for
        System.out.println("===for");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        //3.2 foreach
        System.out.println("=====foreach");
        for (Object object : linkedList
             ) {
            Student stu = (Student) object;
            System.out.println(stu.toString());

        }

        //3.3 Iterator
        System.out.println("====Iterator");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Student stuIte = (Student) iterator.next();
            System.out.println(stuIte.toString());
        }
        //3.4 ListIterator
        System.out.println("===ListIterator");
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()){
            Student stuListIte = (Student)  listIterator.next();
            System.out.println(stuListIte.toString());

        }
        //判断
        System.out.println(linkedList.contains(stu1));
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.indexOf(stu2));
    }
}
