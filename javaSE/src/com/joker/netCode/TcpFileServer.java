package com.joker.netCode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 案例2 实现:客户端上传文件给服务器端
 * TCP 服务器端
 *
 */
public class TcpFileServer {
    public static void main(String[] args) throws IOException {
        //1 创建 ServerSocket
        ServerSocket listener = new ServerSocket(5202);
        System.out.println("服务器已经启动");
        Socket socket = listener.accept();
        InputStream inputStream = socket.getInputStream();
        //4 边读取，边保存
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\2021java学习文件\\learnphoto\\tcp.jpg");
        byte[] buffer = new byte[1024*4];
        int count = 0;
        while ((count = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,count);
        }

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        listener.close();
        System.out.println("接受完毕");
    }
}
