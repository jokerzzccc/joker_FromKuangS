package com.joker.file;

import java.io.File;

/**
 * 案例1：递归遍历文件夹
 * 案例2：递归删除文件夹
 * @author joker_chen
 */
public class Demo02_Case {
    public static void main(String[] args) {
//        listDir(new File("D:\\aaaa_text"));
        deleteDir(new File("D:\\aaaa_text"));
    }
    //递归遍历文件夹：先递归文件夹，再递归文件
    public static void listDir(File dir){
        File[] files = dir.listFiles();//得到的是，aaaa_text 下一级的文件夹及文件
        System.out.println(dir.getAbsoluteFile());//打印文件夹
        if (files != null && files.length > 0){//文件夹不为空（文件夹存在），且，文件长度不为0（即有文件）
            for (File file:
                 files) {
                if (file.isDirectory()){
                    listDir(file);//递归
                } else {
                    System.out.println(file.getAbsoluteFile());//打印文件
                }
            }

        }
    }
    //案例2：递归删除文件夹，先删除文件，再删除文件夹
    public static void deleteDir(File dir){
        File[] files = dir.listFiles();
        if (files != null && files.length > 0){
            for (File file :
                    files) {
                if (file.isDirectory()){
                    deleteDir(file);//遍历
                } else {
                    //删除文件
                    System.out.println(file.getAbsoluteFile() + "删除: " + file.delete());
                }
            }
        }
        //删除文件夹
        System.out.println(dir.getAbsoluteFile() + "删除： " + dir.delete());
    }
}
