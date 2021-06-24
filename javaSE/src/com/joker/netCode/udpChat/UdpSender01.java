package com.joker.netCode.udpChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSender01 {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(5208);

        //准备数据 控制台读取 System.in
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String data = bufferedReader.readLine();//因为不可读，所以必须转成字节数据
            byte[] datas = data.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",5210));

            datagramSocket.send(datagramPacket);
            if (data.equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
}
