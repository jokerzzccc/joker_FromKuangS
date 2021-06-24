package com.joker.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 使用 ObjectOutputStream 实现序列化（写入）
 * 注意事项：
 * （1）序列化类（Student）必须实现 Serializable 接口
 * （2）序列化类中的，对象属性，要求实现 Serializable 接口
 * （3）序列化版本号 ID，保证序列化的类和反序列化的类是同一个类
 * （4）使用 transient (瞬间的) 修饰属性，这个属性不能序列化：比如 public transient int age;
 * （5）静态属性不能序列化
 * （6）序列化多个对象，可以借助集合（如：ArrayList）实现
 *
 */
public class Demo06 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\2021java学习文件\\mdFile\\serial.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //序列化：写入操作
        Student joker = new Student("joker", 20);
        oos.writeObject(joker);

        oos.close();
        System.out.println("serializable over");

    }
}
