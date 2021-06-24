package com.joker.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 练习 Thread 类，实现多线程同步下载图片
 */
public class testThread2 extends Thread{

    private String name;
    private String url;

    public testThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

//下载方法执行体
    @Override
    public void run() {
        webDownloader webDownloader = new webDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        testThread2 t1 = new testThread2("http://img17.3lian.com/201612/20/99b8790a4faae5fcebbe838eb24213ac.jpg","1.jpg");
        testThread2 t2 = new testThread2("http://img17.3lian.com/201612/20/99b8790a4faae5fcebbe838eb24213ac.jpg","2.jpg");
        testThread2 t3 = new testThread2("http://img17.3lian.com/201612/20/99b8790a4faae5fcebbe838eb24213ac.jpg","3.jpg");
//由下载结果可知，线程的执行顺序是由 cpu 调度的
        t1.start();
        t2.start();
        t3.start();
    }
}
//下载器
class webDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));//commons-io 库里的，把文件连接转为文件
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO 异常，downloader方法出现问题");
        }

    }
}
