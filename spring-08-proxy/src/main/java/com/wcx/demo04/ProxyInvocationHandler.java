package com.wcx.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

    /**
     * private UserService userService;
     *
     * public void setUserService(UserService userService) {
            this.userService = userService;
      }
     */

    //改造为如下公共方法
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //使用反射中的method方法
        log(method.getName());
        Object result = method.invoke(target, args);

        return null;
    }

    //打印日志方法
    public void log(String Msg) {
        System.out.println("[Debug]使用了" + Msg + "方法");
    }
}
