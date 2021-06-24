package com.joker.netCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 案例四
 * 用户注册登录客户端
 */
public class UserClient {
    public static void main(String[] args) throws Exception{
        System.out.println("请选择：1 注册，2 登录");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                regist();
                break;
            case 2:
                login();
            default:
                break;
        }
    }
//注册
    public static void regist() throws Exception{
        //1 创建Socket
        Socket socket = new Socket("192.168.1.4", 5204);
        //2 获取输入输出流
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        //3 获取用户信息
        String json = getRegistInfo();
        //4 发送
        bufferedWriter.write(json);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //5 接收回复
        String reply = bufferedReader.readLine();
        System.out.println("服务器回复："+ reply);

        //6 关闭
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
//获取注册信息
    public static String getRegistInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户编号");
        int id = input.nextInt();
        System.out.println("请输入姓名");
        String name = input.next();
        System.out.println("请输入密码");
        String pwd = input.next();
        System.out.println("请输入年龄");
        int age = input.nextInt();
        //{id : 1001 , name : tang , pwd : 036 , age = 21}
        String json = "{id:"+id+",name:"+name+",pwd:"+pwd+",age:"+age+"}";
        return json;
        }
//登录
    public static void login() throws Exception{
//1 创建Socket
        Socket socket = new Socket("192.168.1.4", 5206);
        //2 获取输入输出流
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        //3 获取用户信息
        String json = getLoginInfo();
        //4 发送
        bufferedWriter.write(json);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //5 接收回复
        String reply = bufferedReader.readLine();
        System.out.println("服务器回复："+ reply);

        //6 关闭
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
//获取登录信息
    public static String getLoginInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户编号");
        int id = input.nextInt();
        System.out.println("请输入密码");
        String pwd = input.next();
        //{id : 1001  , pwd : 036 }
        String json = "{id:"+id+",pwd:"+pwd+"}";
        return json;
    }
}
