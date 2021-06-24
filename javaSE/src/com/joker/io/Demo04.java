package com.joker.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * BufferedInputStream
 * @author joker_chen
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("D:\\2021java学习文件\\mdFile\\file.txt");
        BufferedInputStream buffer = new BufferedInputStream(file);//buffer默认大小是8192

        //读取
//        int data = 0;
//
//        while ((data = buffer.read()) != -1){
//            System.out.println((char) data);
//        }
        byte[] buf = new byte[1024];//自定义buffer的大小
        int count = 0;
        while ((count = buffer.read(buf)) != -1){
            System.out.println(new String(buf,0,count));
        }


        buffer.close();//只需关闭buffer,前面的file也会被关闭
    }
}
