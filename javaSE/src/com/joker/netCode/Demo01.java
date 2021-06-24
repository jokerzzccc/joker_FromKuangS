package com.joker.netCode;

import java.net.InetAddress;

/**
 * InetAddress 的使用
 * 1. 创建本地 IP 地址对象
 * 2. 创建局域网 IP 地址对象
 * 3. 创建外网 IP 地址对象
 */
public class Demo01 {
    public static void main(String[] args) throws Exception{
        //1 创建本地 IP 地址对象,常用前两种
        //1.1 InetAddress.getLocalHost()方法
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("IP地址: " +localHost.getHostAddress() + "  主机名" + localHost.getHostName());
        //1.2 InetAddress.getByName("ip地址")
        InetAddress byName = InetAddress.getByName("192.168.1.4");
        System.out.println("IP地址: " +byName.getHostAddress() + "  主机名" + byName.getHostName());
        //1.3getByName("127.0.0.1")
        InetAddress byName1 = InetAddress.getByName("127.0.0.1");
        System.out.println("IP地址: " +byName1.getHostAddress() + "  主机名" + byName1.getHostName());
        //1.4getByName("localhost")
        InetAddress byName2 = InetAddress.getByName("localhost");
        System.out.println("IP地址: " +byName2.getHostAddress() + "  主机名" + byName2.getHostName());

        //2 创建局域网 IP 地址对象
//        InetAddress byName3 = InetAddress.getByName("192.168.1.5");//随便写的地址，所以，不可达
//        System.out.println("IP地址: " +byName3.getHostAddress() + "  主机名" + byName3.getHostName());
//        System.out.println("2秒内是否可达：" + byName3.isReachable(2000));

        //3 创建外网 IP 地址对象
        InetAddress byName4 = InetAddress.getByName("www.baidu.com");
        System.out.println("IP地址: " +byName4.getHostAddress() + "  主机名" + byName4.getHostName());
        System.out.println("2秒内是否可达：" + byName4.isReachable(2000));
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");//获得所有的ip地址
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.getHostAddress());
        }

    }
}
