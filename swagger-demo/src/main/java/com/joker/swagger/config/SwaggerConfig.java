package com.joker.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    @Bean//配置swagger的Docket的bean实例
    public Docket docket(Environment environment){
        //设置要显示的swagger 环境
        Profiles profiles=Profiles.of("dev");
        //environment.acceptsProfiles 判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("joker")
                .enable(flag)//enable 是否启动swagger，如果为false,则swagger，不能在浏览器种访问
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式：
                //basePackage 指定要扫描的包basePackage("com.joker.swagger.controller")
                //any() 扫描全部
                //none() 都不扫描
                //withMethodAnnotation()  扫描方法上的注解
                //withClassAnnotation() 扫描类上的注解，参数是一个注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.joker.swagger.controller"))
                //指定请求的路径，即，只在joker下的才扫描
//                .paths(PathSelectors.ant("/joker/**"))
                .build();
    }
    //配置swagger信息 =  ApiInfo
    //看源码，看构造函数
    public ApiInfo apiInfo(){
        //自定义作者信息
        Contact DEFAULT_CONTACT = new Contact("joker", "", "");
        return new ApiInfo(
                "joker-Api Documentation",
                "joker-Api Documentation",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                 new ArrayList());
    }
}
