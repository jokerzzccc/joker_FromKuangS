package com.joker.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * BufferedOutputStream
 * @author joker_chen
 *
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        FileOutputStream file_out = new FileOutputStream("D:\\2021java学习文件\\mdFile\\buffer.txt");
        BufferedOutputStream buffer_out = new BufferedOutputStream(file_out);
        //写入文件
        for (int i = 0; i < 10; i++) {
            buffer_out.write("hello\r".getBytes());//写入8k缓冲区,而在硬盘里看不见，
            buffer_out.flush();//每执行一次，就刷新一次，刷新到硬盘，防止数据的丢失
        }
        //关闭，调用close() 时，内部会自动调用 flush(),
       buffer_out.close();


    }
}
