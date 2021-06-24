package com.joker.map;


import java.util.HashMap;
import java.util.Map;

/**
 * HashMap集合的使用
 * 存储结构：哈希表（数组+链表+红黑树）
 * 使用key的hashCode()和equals()作为重复的判断依据:重写key类型的 hashCode()和 equals()
 * @author joker_chen
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        //创建集合
        HashMap<Student_Map, String> students = new HashMap<>();

        Student_Map stu1 = new Student_Map("zhao",111);
        Student_Map stu2 = new Student_Map("qian",222);
        Student_Map stu3 = new Student_Map("sun",333);
//添加元素，put()
        students.put(stu1,"chongqing");
        students.put(stu2,"chengdu");
        students.put(stu3,"kunming");

        students.put(new Student_Map("zhao",111),"sichuan");//这个是可以加进来的，
        // 为了当姓名学号都相同时，加不进来，就要重写hashCode(),equals()

        System.out.println("the number of elements: " + students.size());
        System.out.println(students.toString());
//        //2.删除元素
//        students.remove(stu1);
//        System.out.println(students.toString());
        //3.遍历
        //3.1 使用keySet()遍历
        for (Student_Map key : students.keySet()) {
            System.out.println(key+" "+students.get(key));
        }
        //3.2 使用entrySet()遍历
        for (Map.Entry<Student_Map, String> entry : students.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //4.判断
        //
        System.out.println(students.containsKey(new Student_Map("qian", 222)));
        System.out.println(students.containsValue("sichuan"));

    }
}
