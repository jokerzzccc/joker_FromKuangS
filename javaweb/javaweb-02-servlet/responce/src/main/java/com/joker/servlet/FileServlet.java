package com.joker.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取下载文件的路径
        String path = "D:\\2021_java_project\\javaweb\\javaweb-02-servlet\\responce\\src\\main\\resources\\t2.png";
        System.out.println("下载文件的路径：" + path);
        //2. 下载文件名
        String fileName = path.substring(path.lastIndexOf("\\" )+ 1);
        //3. 设置浏览器可以支持下载我们的东西(百度找头消息)
        //中午文件名需要URLEncoder.encode编码，否则可能下载文件名会乱码
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        //4. 获取下载文件的数据流
        FileInputStream inputStream = new FileInputStream(path);
        //5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024*10];
        //6. 获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //7. 将FileOutputStream流写入到缓冲区（buffer）,使用OutputSteam 将缓冲区中的数据输出到客户端
        while ((len = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,len);
        }
        //8. 关闭
        inputStream.close();
        outputStream.close();
            }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
