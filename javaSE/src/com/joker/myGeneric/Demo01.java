package com.joker.myGeneric;

import com.joker.classused.Student;

import java.util.ArrayList;

/**
 * 泛型集合
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        //指定类型为String,此时就只能添加String类型
        arrayList.add("aaa");
        arrayList.add("bbb");

        System.out.println(arrayList);

        for (String string :
                arrayList) {
            System.out.println(string);
        }

        ArrayList<Student> arrayList1 = new ArrayList<Student>();
        //此时只能添加Student类型的
        Student stu1 = new Student("zhao", 10);
        Student stu2 = new Student("qian", 20);
        Student stu3 = new Student("sun", 30);
        arrayList1.add(stu1);
        arrayList1.add(stu2);
        System.out.println(arrayList1);

    }
}
