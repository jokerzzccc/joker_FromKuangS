package com.joker.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();//返回数组，说明cookie可能有多个
        if (cookies!=null){
            writer.print("上一次访问时间");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastLoginTime")){
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    writer.print(date.toString());
                }
            }
        }else {
            writer.print("第一次访问网站");
        }
        //服务器给客户端响应一个cookie
        Cookie cookie1 = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        cookie1.setMaxAge(24*60*60);//cookie有效期为1天
        resp.addCookie(cookie1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
