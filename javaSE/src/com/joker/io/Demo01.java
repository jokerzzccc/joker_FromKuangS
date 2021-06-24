package com.joker.io;

import java.io.FileInputStream;

/**
 * FileInputStream
 *
 * @author joker_chen
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //创建FileInputStream，并指定文件路径
        FileInputStream fileInputStream = new FileInputStream("D:\\2021java学习文件\\mdFile\\file.txt");

        //读取文件
        fileInputStream.read();
//        //2.1 读取单个字节
//        int data = 0;
//        read()，读取到没有的时候会返回-1
//        while ((data =fileInputStream.read()) != -1){
//            System.out.print((char) data);
//        }
        //2.2 一次读取多个字节

        byte[] bytes = new byte[1024];
        int count =  0;
        while ((count = fileInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,count));
        }

        //关闭
        fileInputStream.close();
        System.out.println("");
        System.out.println("over");
    }
}
