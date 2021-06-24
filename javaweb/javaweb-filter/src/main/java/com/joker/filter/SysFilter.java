package com.joker.filter;

import com.joker.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统登录过滤器，即用户判断
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getSession().getAttribute(Constant.USER_SESSION) == null){
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
        chain.doFilter(req,resp);
    }
    @Override
    public void destroy() {

    }
}
