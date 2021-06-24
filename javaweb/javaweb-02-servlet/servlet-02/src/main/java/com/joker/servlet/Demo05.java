package com.joker.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo05 extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/db.properties");//路径根据target里的相对路径
        Properties prop = new Properties();
        prop.load(resourceAsStream);
        String username = prop.getProperty("username");
        String pwd = prop.getProperty("password");

        resp.getWriter().print(username + ":"+pwd);
    }
}
