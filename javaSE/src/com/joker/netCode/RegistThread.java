package com.joker.netCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 案例4
 * 实现注册功能的线程类
 */
public class RegistThread extends Thread{
    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(5204);
            System.out.println("注册服务器已经启动");
            Socket socket = listener.accept();
            //获取输入输出流
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            //4 接受客户端发送的数据 {id : 1001 , name : tang , pwd : 036 , age = 21}
            String json = bufferedReader.readLine();
            //id : 1001 , name : tang , pwd : 036 , age = 21
            String[] infos = json.substring(1, json.length() - 1).split(",");//去掉大括号,且用逗号分割
            String id = infos[0].split(":")[1];
            //5 加载属性文件 写了一个工具类Tools.loadProperties()
            Properties properties = Tools.loadProperties();
            //6 判断id有没有
            if (properties.containsKey(id)){
                //有
                bufferedWriter.write("此用户已经存在");
            } else {//没有
                //保存属性文件 自己的工具类Tools.saveProperties()
                Tools.saveProperties(json);
                bufferedWriter.write("注册成功");
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
            listener.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
