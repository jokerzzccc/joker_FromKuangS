package com.joker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //这个是 链式编程
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页，只有对应的有权限的人才可以访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("level1/**").hasRole("vip1")
                .antMatchers("level2/**").hasRole("vip2")
                .antMatchers("level3/**").hasRole("vip3");

        //没有权限会默认跳到登录页 /login，需要开启登录的页面
        //这里看看formLogin的源码
        http.formLogin().loginPage("/toLogin");
        //开启了注销功能
        http.logout().logoutSuccessUrl("/");
    }
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据应该从数据库读，auth.jdbcAuthentication()
        //这里只是为了测试，用的缓存操作
        //格式 可以从formLogin()源码里看见
        //passwordEncoder 加密
        //BCryptPasswordEncoder加密的一种
        //srping security 5 有新增了很多加密方法

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("joker").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }
}
