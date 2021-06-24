package com.joker.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行：判断什么时情况下登录
        //放行1 : 登录页面
        if (request.getRequestURI().contains("goLogin")){
            return true;
        }
        //放行，提交登录的时候
        if (request.getRequestURI().contains("login")){
            return true;
        }

        //放行2 已经登录过
        if (session.getAttribute("userLoginInfo") != null){
            return true;
        }

        //拦截：判断什么情况没有登录
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
