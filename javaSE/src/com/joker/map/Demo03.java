package com.joker.map;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeMap
 *
 */
public class Demo03 {
    public static void main(String[] args) {
        TreeMap<Student_Map, String> students = new TreeMap<>();


        Student_Map stu1 = new Student_Map("zhao",111);
        Student_Map stu2 = new Student_Map("qian",222);
        Student_Map stu3 = new Student_Map("sun",333);
//添加元素，put(),要Student_Map类要实现Comparable接口，
        students.put(stu1,"chongqing");
        students.put(stu2,"chengdu");
        students.put(stu3,"kunming");

        System.out.println(students);

        //2.删除元素
        students.remove(new Student_Map("zhao", 111));
        System.out.println(students.toString());
        //3.遍历
        //3.1 使用keySet()
        for (Student_Map key : students.keySet()) {
            System.out.println(key+" "+students.get(key));
        }
        //3.2 使用entrySet()
        for (Map.Entry<Student_Map, String> entry : students.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //4.判断
        System.out.println(students.containsKey(stu1));
        System.out.println(students.isEmpty());
    }
}
