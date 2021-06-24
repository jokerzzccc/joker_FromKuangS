package com.joker.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三：使用注解方式实现AOP
@Aspect//标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.joker.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前前前前=========");
    }
    @After("execution(* com.joker.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后后后后=========");
    }
    //在环绕增强中，我们可以定义一个参数，代表，我们要获取处理切入的点
    @Around("execution(* com.joker.service.UserServiceImpl.*(..))")
    public void aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        //执行方法
        joinPoint.proceed();
        System.out.println("环绕后");
    }
}
