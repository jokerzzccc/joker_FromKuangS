package com.joker.netCode;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 还是要等待发送端的连接
 */
public class UdpServerDemo02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(5209);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);//阻塞接受

        System.out.println(datagramPacket.getAddress().getHostAddress());
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()
        ));

        datagramSocket.close();


    }
}
