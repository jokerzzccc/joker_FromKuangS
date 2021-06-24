package com.joker.netCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 案例2
 * TCP 开发
 * 客户端
 */
public class TcpFileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.4", 5202);

        OutputStream outputStream = socket.getOutputStream();
        //边读取文件，边发送
        FileInputStream fileInputStream = new FileInputStream("E:\\精选image\\timg4.jpg");
        byte[] buf = new byte[1024*4];
        int count = 0;
        while ((count = fileInputStream.read(buf)) != -1){
            outputStream.write(buf,0,count);
        }

        fileInputStream.close();
        outputStream.close();
        socket.close();

        System.out.println("发送完毕");
    }
}
