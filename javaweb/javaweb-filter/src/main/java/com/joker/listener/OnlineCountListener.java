package com.joker.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数：统计session
public class OnlineCountListener implements HttpSessionListener {
    @Override//创建session监听
    //一旦创建一次，就会触发一次这个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer count =(Integer) servletContext.getAttribute("OnlineCount");

        if (count==null){
            count = new Integer(1);
        }else {
            int count2 = count.intValue();
            count = new Integer(count2 + 1);
        }

        servletContext.setAttribute("OnlineCount",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer count =(Integer) servletContext.getAttribute("OnlineCount");

        if (count==null){
            count = new Integer(0);
        }else {
            int count2 = count.intValue();
            count = new Integer(count2 - 1);
        }

        servletContext.setAttribute("OnlineCount",count);
    }
}
