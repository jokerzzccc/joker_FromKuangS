package com.joker.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 使用 ObjecInputSteam 实现反序列化 （读取重构成对象）
 *
 * @author joker_chen
 */
public class Demo07 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("D:\\2021java学习文件\\mdFile\\serial.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        //读取文件（反序列化）
        Student stu = (Student) ois.readObject();
//        Student stu2 = (Student) ois.readObject();//不能读多个

        ois.close();
        System.out.println("over");

        System.out.println(stu.toString());

    }
}
