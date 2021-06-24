package com.joker.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * 配置的时候，倒着写，顺序从realm->securityManager->subject,因为会依次调用
 */
@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean    第三步
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置securityManager
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加内置过滤器 ,有5种
        /*
         anon : 无需认证就可以访问
         authc : 必须认证了才能访问
         user : 必须拥有 记住我 rememberMe 功能才能用
         perms  ；拥有对某个资源的权限才能用
         role : 拥有某个角色权限才能访问
         */
        //拦截
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //授权,正常情况下，未授权会跳转到未授权页面
        //perms[user:add] 表示要有user:add，这个权限才可以，访问，一般会在数据库设置权限字段
        filterChainDefinitionMap.put("/user/add","perms[user:add]");
        filterChainDefinitionMap.put("/user/update","perms[user:update]");

        filterChainDefinitionMap.put("/user/add","authc");
        filterChainDefinitionMap.put("/user/update","authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //未授权页面
        bean.setUnauthorizedUrl("/unauthorized");

        return bean;

    }
    //第二步   DefaultWebSecurityManager
    //@Qualifier("userRealm") 就是用来绑定自定义的realm
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建realm对象 第一步 需要自定义
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //ShiroDialect 用来整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
