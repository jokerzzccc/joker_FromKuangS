package com.joker.url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL 下载网络资源
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        //随便找一个网上urlhttps://img.souutu.com/2020/0430/20200430100647480.jpg
        URL url = new URL("https://m701.music.126.net/20210219231251/f77824803c15a43326251b9e30569905/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/5067255101/0779/09f1/a91e/4ec2d9979faa8d42b6fa3ae0d57919af.m4a");

        HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("urlTest.m4a");//注意文件格式，与url的对应

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
