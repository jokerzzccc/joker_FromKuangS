package com.joker.config;

import com.joker.pojo.User;
import com.joker.service.UserService;
import com.joker.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的realm ,要继承 AuthorizingRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;

    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权");
        //添加授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser =(User) subject.getPrincipal();//拿到User

        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");
        //用户名，密码 ，本来应该在数据库里取出
//        String name = "root";
//        String pwd = "123456";
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //连接真实数据库
        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        if (user==null){
            return null;
        }

//        if (!usernamePasswordToken.getUsername().equals((name))){
//            return null;//返回null,就是抛出异常 会自动抛出用户名异常
//        }

        //密码认证，shiro做，我们不用做
        //可以在这里设置断点，看到
        // CredentialsMatcher 接口，用于加密，有很多实现类  比如MD5 ,md5盐值加密
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
