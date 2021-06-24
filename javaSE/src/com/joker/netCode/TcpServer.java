package com.joker.netCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 案例1
 * 基于 TCP 协议的服务器端开发
 * 实现：客户端发送数据给服务器端
 * 1 创建ServerSocket，指定端口号。
 * 2 调用accept(),等待客户端接入。
 * 3 获取输入流，读取客户端发送的数据
 * 4 获取输出流，发送数据给客户端。
 * 5 关闭释放资源。
 * 住：先运行服务器，再运行客户端
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        //1 创建ServerSocket，指定端口号。
        ServerSocket listener = new ServerSocket(5205);//测试端口最好在1024之后，因为之前的已经被占用

        //2 调用accept(),等待客户端接入。是一个阻塞方法（如果客户端没有请求，则阻塞）
        System.out.println("服务器已启动");
        Socket socket = listener.accept();//返回的是客户端 Socket

        //3 获取输入流，读取客户端发送的数据
        InputStream inputStream = socket.getInputStream();//因为这个字节流不能接受中文，所以有下面的代码
        //把字节流转换为字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String data = bufferedReader.readLine();
        System.out.println("客户发送的数据： "+ data);

        //4 获取输出流，发送数据给客户端。(因为是简单案例，所以可选)
        //5 关闭释放资源。
        bufferedReader.close();
        socket.close();
        listener.close();
    }

}
