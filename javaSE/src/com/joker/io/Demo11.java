package com.joker.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 使用字符缓冲流读取文件
 * BufferedReader
 *
 * @author joker_chen
 */
public class Demo11 {
    public static void main(String[] args) throws Exception{
        //创建缓冲流
        FileReader fr = new FileReader("D:\\2021java学习文件\\mdFile\\fw.txt");
        BufferedReader br = new BufferedReader(fr);
        //读取
//        //第一种方式
//        char[] buf = new char[1024];
//        int count = 0;
//        while ((count = br.read(buf)) != -1){
//            System.out.println(new String(buf,0,count));
//
//        }
        //第二种方式,一行一行的读取
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
    }
}
