package com.joker.netCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 案例3 的线程类
 *
 */
public class SocketThread extends Thread{
    private Socket socket;

    public SocketThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        if (socket != null){
            BufferedReader bufferedReader = null;
            try {
                InputStream inputStream = socket.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                while (true){
                    String data = bufferedReader.readLine();
                    if (data == null){//客户端已经关闭
                        break;//则服务器退出
                    }
                    System.out.println(socket.getInetAddress() + "说了：" + data);
                    if (data.equals("886") || data.equals("byebye")){
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                    socket.close();
                    System.out.println(socket.getInetAddress()+ "退出了");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
