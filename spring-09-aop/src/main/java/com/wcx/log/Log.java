package com.wcx.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


public class Log implements MethodBeforeAdvice {

    /**
     * @param method the method being invoked
     * @param args   the arguments to the method
     * @param target the target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getClass().getName()+"的"+ method.getName()+"被执行");
    }
}
