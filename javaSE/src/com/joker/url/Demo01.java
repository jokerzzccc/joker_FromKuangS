package com.joker.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL类 常用方法
 */
public class Demo01 {
    public static void main(String[] args) throws MalformedURLException {
        //创建一个url
        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=joker&password=123");
        //常用方法
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());//主机ip
        System.out.println(url.getPort());//端口
        System.out.println(url.getPath());//文件
        System.out.println(url.getFile());//全路径
        System.out.println(url.getQuery());//查询参数

    }
}
