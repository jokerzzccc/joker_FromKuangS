package com.joker.servlet;

import com.joker.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session = req.getSession();
        //给session中放东西
        session.setAttribute("name",new Person("joker_陈",10));
        //常用方法
        //获取session的ID
        String id = session.getId();
        //判断是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功，id="+id);
        }else {
            resp.getWriter().write("session已经存在，id="+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
