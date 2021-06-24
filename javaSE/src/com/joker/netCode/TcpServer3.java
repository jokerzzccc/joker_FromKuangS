package com.joker.netCode;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 案例3：实现多个客户端发送数据给服务器
 * 服务器端
 */
public class TcpServer3 {
    public static void main(String[] args) throws Exception{
        ServerSocket listener = new ServerSocket(5203);

        System.out.println("服务器已经启动");
        while (true){
            Socket socket = listener.accept();
            System.out.println(socket.getInetAddress() + "进来了");
            //创建线程对象，负责接受数据
            new SocketThread(socket).start();
        }
    }
}
