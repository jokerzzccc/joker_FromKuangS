package com.joker.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection 的使用：保存学生信息
 * @author joker
 */
public class Demo02 {
    public static void main(String[] args) {
        //新建Collection对象
        Collection collection = new ArrayList();
        Student stu1 = new Student("zhangsan",10);
        Student stu2 = new Student("lisi", 11);
        Student stu3 = new Student("wangwu", 12);
        //添加学生数据
        collection.add(stu1);
        collection.add(stu2);
        collection.add(stu3);
        System.out.println("元素个数"+collection.size());
        System.out.println(collection.toString());

//        //删除
//        collection.remove(stu1);
//        System.out.println(collection.size());
//        collection.clear();//只是删除集合的地址，原数据仍在堆里
        //遍历
        //法1 for-each
        for (Object object :
                collection) {
            Student stu = (Student) object;
            System.out.println(stu.toString());
        }
        //法2 iterator
        System.out.println("==========Iterator==========");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Student stu_it = (Student) iterator.next();
            System.out.println(stu_it.toString());
        }
        

    }
}
