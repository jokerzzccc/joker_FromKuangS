package com.joker.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.joker.pojo.Role;
import com.joker.pojo.User;
import com.joker.service.role.RoleServiceImpl;
import com.joker.service.user.UserService;
import com.joker.service.user.UserServiceImpl;
import com.joker.util.Constants;
import com.joker.util.PageSupport;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 修改密码
 * 实现这个Servlet复用
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("savepwd")){
            this.updatePwd(req,resp);
        } else if (method != null && method.equals("pwdmodify")){
            this.pwdModify(req,resp);
        }else if (method != null && method.equals("query")){
            this.query(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
//从duGet()里提出方法，是为了实现 servlet 的复用
    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        //从session获取id
        Object object = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean flag = false;
        if (object !=null && !(StringUtils.isNullOrEmpty(newpassword))){
            UserServiceImpl userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) object).getId(), newpassword);
            if (flag) {
                req.setAttribute("message","密码修改成功，请退出使用新密码登录");
                //密码修改成功，移除当前session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        }else {
            req.setAttribute("message", "新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //验证旧密码,因为session中有用户的旧密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){

        Object object = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //万能的Map:存放数据，这里创建 结果集 resultMap 存放Ajax的result的各种值,
        Map<String, String> resultMap = new HashMap<>();
        if (object == null){//session失效过期了,对应web.xml里配置过期时间
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){//旧密码为空
            resultMap.put("result","error");
        }else {
            String userPassword = ((User) object).getUserPassword();//session中用户的密码
            if (oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }


        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //JSONArray工具类，阿里巴巴的依赖fastjson 把Map 转为JSON，转换格式
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //重点，难点，查询用户列表
    public void query(HttpServletRequest req, HttpServletResponse resp){
        //从前端获取数据
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;//默认给0 ，是因我如果什么都不给，就是空，

        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;

        //第一次走这个请求，一定是第一页，且页面大小固定
        int pageSize = 5;//可以把这个配置到配置文件中，方便后期修改
        int currentPageNo=1;
        if(queryUserName == null){
            queryUserName = "";
        }
        if (temp != null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);//给查询赋值，0.1.2.3
        }
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户的总数
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        //控制首页和尾页
        int totalPageCount = pageSupport.getTotalPageCount();
        //如果页面要小于1 了，就显示第一页
        if (currentPageNo < 1){
            currentPageNo = 1;
        }else if (currentPageNo >totalPageCount){//当前页大于了最后一页，
            currentPageNo = totalPageCount;
        }

        //获取用户列表展示
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList",userList);
        //获取角色列表展示
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);


        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
