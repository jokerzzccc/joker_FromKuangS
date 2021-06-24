package com.joker.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 使用FileReader 和FileWriter 复制文本文件。只能复制文本文件，不能复制图片或二进制文件，因为图片没有字符编码
 * 字节流可以复制任意文件
 * @author joker_chen
 */
public class Demo10 {
    public static void main(String[] args) throws Exception {
        //创建
        FileReader fr = new FileReader("D:\\2021java学习文件\\mdFile\\fw.txt");
        FileWriter fw = new FileWriter("D:\\2021java学习文件\\mdFile\\fw2.txt");
        //读写
        int data = 0;
        while ((data = fr.read()) != -1){
            fw.write(data);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
