package com.joker.netCode;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 案例1
 * 基于TCP 的客户端开发
 * 1 创建客户端套接字（Socket），指定服务器IP + 端口号。
 * 2 获取输出流，发送数据给服务器
 * 3 获取输入流，读取服务器回复的数据
 * 4 关闭释放资源。
 */
public class TcpClient {
    public static void main(String[] args) throws Exception{
        //* 1 创建客户端套接字（Socket），指定服务器IP + 端口号。
        Socket socket = new Socket("192.168.1.4",5205);
        // * 2 获取输出流，发送数据给服务器
        OutputStream outputStream = socket.getOutputStream();//得到一个字节输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        bufferedWriter.write("你好服务器，我是客户端");

        //* 3 获取输入流，读取服务器回复的数据（因为服务器端没选，所以这里也可选）
        //  4 关闭释放资源。
        bufferedWriter.close();
        socket.close();
    }
}
