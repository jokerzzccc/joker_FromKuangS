package com.joker.netCode;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 案例3
 * TCP 客户端，
 *  * 持续一直向服务器发送数据
 */
public class TcpClient3 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("192.168.1.4",5203);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

        //3 控制输入
        Scanner input = new Scanner(System.in);
        while(true){
            String data = input.nextLine();
            bufferedWriter.write(data);
            bufferedWriter.newLine();//发送换行符，因为，服务器线程里是用的readLine()
            bufferedWriter.flush();
            if (data.equals("886") || data.equals("byebye")){
                break;
            }
        }
        //4 关闭
        bufferedWriter.close();
        socket.close();
    }
}
