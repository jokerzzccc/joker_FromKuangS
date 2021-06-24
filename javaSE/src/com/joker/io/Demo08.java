package com.joker.io;

import java.io.FileReader;

/**
 * 字符流，FileReader
 * @author joker_chen
 *
 */
public class Demo08 {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("D:\\2021java学习文件\\mdFile\\ziFuLiu.txt");

        //读取
//        //2.1单个字符读取
//        int data = 0;
//        while ((data = fr.read()) != -1){
//            System.out.println((char) data);
//        }
        //2.2自建一个缓冲区，一次性读取
        char[] buf = new char[1024];
        int count = 0;
        while ((count = fr.read(buf)) != -1){
            System.out.println(new String(buf,0,count));
        }
        fr.close();
    }
}
