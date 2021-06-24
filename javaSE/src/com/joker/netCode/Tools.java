package com.joker.netCode;

import java.io.*;
import java.util.Properties;

/**
 * 案例4
 * 工具类
 * 负责加载文件和保存所有文件
 */
public class Tools {
    //1 加载属性文件
    public static Properties loadProperties() {
        //1 创建集合
        Properties properties = new Properties();
        //2 判断文件是否存在
        File file = new File("users.properties");
        if (file.exists()){
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                properties.load(fileInputStream);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
        return properties;
    }
    //2 保存属性文件
    public static void saveProperties(String json){
        String[] infos = json.substring(1, json.length() - 1).split(",");//去掉大括号,且用逗号分割
        String id = infos[0].split(":")[1];
        FileOutputStream fileOutputStream = null;
        //保存
        try {
            fileOutputStream = new FileOutputStream("users.properties",true);
            Properties properties = new Properties();
            properties.setProperty(id,json);
            properties.store(fileOutputStream,null);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
