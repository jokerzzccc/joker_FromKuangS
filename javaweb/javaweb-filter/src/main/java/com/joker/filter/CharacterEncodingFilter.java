package com.joker.filter;
import javax.servlet.*;
import java.io.IOException;

/**
 * 中文乱码过滤器
 */
public class CharacterEncodingFilter implements Filter{

    @Override
    //初始化：web服务器启动，就已经初始化了，随时等待过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    //chain: 链
    /*
    总结：
    1. 过滤器中的所有代码在过滤特定请求的时候都会执行
    2. 必须要让过滤器继续通行 chain.doFilter(request,response); 就是把代码往下转交
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前");
        //固定代码
        //让我们的请求继续走，如果不写，程序到这里就会被拦截停止
        chain.doFilter(request,response);
        System.out.println("CharacterEncodingFilter 执行后");
    }

    @Override
    //销毁：web服务器停止的时候，过滤器会销毁
    public void destroy() {

    }
}
