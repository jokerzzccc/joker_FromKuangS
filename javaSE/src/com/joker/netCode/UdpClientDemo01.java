package com.joker.netCode;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *不需要连接服务器
 */
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1. 建立一个Socket
        DatagramSocket datagramSocket = new DatagramSocket();

        //2 建一个包
        String message = "hello server";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 5209;
        //数据，数据的起始长度，要发送给谁
        DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(),0,message
        .getBytes().length,localhost,port);

        //3 发送包
        datagramSocket.send(datagramPacket);
        //4 关闭流
        datagramSocket.close();

    }
}
