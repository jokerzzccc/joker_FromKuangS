package com.joker.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *文件字节流案例：复制文件
 * @author joker_chen
 */
public class Demo03 {
    public static void main(String[] args) throws  Exception{
        FileInputStream fileInputStream = new FileInputStream("D:\\2021java学习文件\\mdFile\\file.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\2021java学习文件\\mdFile\\file2.txt");
        //一边读，一边写
        byte[] bytes = new byte[1024];
        int count = 0;//count保存实际读取的个数
        while ((count = fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,count);//防止文件大于bytes，就要设置off(起始)，len(结束长度)，的值
        }

        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("duplicate over");
    }
}
