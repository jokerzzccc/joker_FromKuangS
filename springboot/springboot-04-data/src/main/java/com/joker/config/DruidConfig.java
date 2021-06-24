package com.joker.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration//这个注解就相当于，bean的xmL文件
public class DruidConfig {
    //自定义组件
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //  后台监控
    //相当于web.xml, ServletRegistrationBean
    //因为SpringBoot 内置了servlet 容器，所以，没有web.xml,所以，就用替代方法 ： ServletRegistrationBean
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //后台需要有任登录，账号密码设置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //登录的key值是固定的，loginUsername loginPassword ，不能随便写
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁可以访问
        //这个的value值，可以是一个具体的 比如，localhost，也可以不写，就是都可以访问
        initParameters.put("allow","");
//        //禁止谁能访问
//        initParameters.put("joker","ip地址");//配置了ip,这个ip就禁止访问了

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //过滤的请求
        HashMap<String, String> initParameters = new HashMap<>();
        //这些东西不进行统计
        //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
//        //"/*" 表示过滤所有请求
//        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
