package com.wcx.customer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//将这个类标记为切面，等同于在applicationContext.xml中配置为切面
public class AnnotationPointCut {

    @Before("execution(* com.wcx.service.UserServiceImpl.*(..))")
    public void Before(){
        System.out.println("=====方法执行前=====");
    }

    @After("execution(* com.wcx.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("=====方法执行后=====");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取切入的点
    @Around("execution(* com.wcx.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("*****环绕前*****");

        //获得签名（类的信息）
        Signature signature = joinPoint.getSignature();
        //执行方法
        Object proceed = joinPoint.proceed();

        System.out.println("*****环绕后******");

        System.out.println(proceed);
    }
}
