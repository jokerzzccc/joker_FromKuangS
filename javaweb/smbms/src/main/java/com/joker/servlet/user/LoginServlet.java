package com.joker.servlet.user;

import com.joker.pojo.User;
import com.joker.service.user.UserServiceImpl;
import com.joker.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet 控制层：接收前端用户参数，调用业务层，转发视图
 */
public class LoginServlet extends HttpServlet {
    //servlet 在控制层，要调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传递的用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //和数据库中的密码对比，调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);
        if (user != null){//查有此人，可以登录
            //将用户的信息放到Session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        }else {//查无此人
            //转发回登录页面，顺带提示它，用户名或者密码错误
            req.setAttribute("error","用户名或者密码错误");//login.jsp，有${error}
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
