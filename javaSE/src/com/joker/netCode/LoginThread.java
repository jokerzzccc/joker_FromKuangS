package com.joker.netCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 案例4
 * 负责登录的线程
 */
public class LoginThread extends Thread{
    @Override
    public void run() {
        try {
            //1 创建ServerSocket
            ServerSocket listener = new ServerSocket(5206);
            System.out.println("登录服务器已经启动");
            //2 调用accept()方法
            Socket socket = listener.accept();
            //获取输入输出流
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            //4 接受客户端发送的数据 {id : 1001  , pwd : 036 }
            String json = bufferedReader.readLine();
            // id : 1001  , pwd : 036
            String[] infos = json.substring(1, json.length() - 1).split(",");//去掉大括号,且用逗号分割
            String id = infos[0].split(":")[1];
            //5 加载属性文件 写了一个工具类Tools.loadProperties()
            Properties properties = Tools.loadProperties();
            //6 判断是否存在
            if (properties.containsKey(id)){
                //判断密码是否正确
                String pwd = infos[1].split(":")[1];
                String value = properties.getProperty(id);
                String[] arr = value.substring(1, value.length() - 1).split(",");
                String pwd2 = arr[2].split(":")[1];
                if (pwd.equals(pwd2)) {
                    bufferedWriter.write("登录成功");
                }else {
                    bufferedWriter.write("密码错误 ");
                }
            } else {//没有


                bufferedWriter.write("用户名或密码错误");
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

