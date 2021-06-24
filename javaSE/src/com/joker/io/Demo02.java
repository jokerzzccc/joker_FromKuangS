package com.joker.io;

import java.io.FileOutputStream;

/**
 * FileOutputStream
 *
 * @author joker_chen
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\2021java学习文件\\mdFile\\file.txt",true);
        //2 写入文件
        //2.1单个写入
//        fileOutputStream.write(   97);
//        fileOutputStream.write('b');
//        fileOutputStream.write('c');
        //2.2 一次性写入多个字符，就是调用不同的write()
        String str = "test";
        fileOutputStream.write(str.getBytes());
            //每次执行都会覆盖原有的文本，若要不覆盖，就在构造方法里，append 设置为 true，变成追加

        fileOutputStream.close();
        System.out.println("excute over");

    }
}
