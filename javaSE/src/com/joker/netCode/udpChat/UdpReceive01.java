package com.joker.netCode.udpChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive01 {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(5210);
        while (true){
            //准备接受包裹
            byte[] container = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(container,0,container.length);
            datagramSocket.receive(datagramPacket);//阻塞式接受包裹

            //断开连接 bye
            byte[] data = datagramPacket.getData();
            String receiveData = new String(data, 0, data.length);
            System.out.println(receiveData);
            if (receiveData.equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
}
