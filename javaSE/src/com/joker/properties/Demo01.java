package com.joker.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

/**
 * Properties 集合的使用
 *
 * @author joker_chen
 */
public class Demo01 {
    public static void main(String[] args) throws Exception{
        //1 创建
        Properties properties = new Properties();
        //添加数据
        properties.setProperty("username","zhangsan");
        properties.setProperty("age","20");

        System.out.println(properties.toString());
        //2 删除
        //3 遍历
        //3.1 使用 keySet
        //3.2 使用 entrySet
        //3.3 使用 stringPropertyNames()
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String pro :
                propertyNames) {
            System.out.println(pro + "-----" + properties.getProperty(pro));
        }
        //4 和流有关的方法
//        //4.1 list()
//        PrintWriter pw = new PrintWriter("D:\\2021java学习文件\\mdFile\\pw.txt");
//        properties.list(pw);//打印到一个打印流里
//        pw.close();

//        //4.2 store() 保存
//        //属性集合的文件扩展名一般用 .properties 这种文件不能有中文
//        FileOutputStream fos = new FileOutputStream("D:\\2021java学习文件\\mdFile\\store.properties");
//        properties.store(fos,"注释");//有中文就用字节流的 store，没中文就用字符流的
//        fos.close();

        //4.3 load() 加载,重点
        Properties properties2 = new Properties();
        FileInputStream fis = new FileInputStream("D:\\2021java学习文件\\mdFile\\store.properties");
        properties2.load(fis);
        fis.close();
        System.out.println(properties2.toString());


    }
}
