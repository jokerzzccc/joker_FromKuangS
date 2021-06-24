package com.joker.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

//传递中文数据,解决乱码问题，就是
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();//返回数组，说明cookie可能有多个
        if (cookies!=null){
            writer.print("上一次访问时间");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastLoginTime")){
                    URLDecoder.decode(cookie.getValue(),"utf-8");//解码
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    writer.print(date.toString());
                }
            }
        }else {
            writer.print("第一次访问网站");
        }
        Cookie cookie = new Cookie("name", URLEncoder.encode("小丑","utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
