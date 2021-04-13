package com.wcx.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyInvocationHandler 用于生成代理类
 * InvocationHandler 用于实现代理类的中的方法，返回结果
 */
//使用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        seeHouse();
        //动态代理的机制就是使用反射机制实现
        Object result = method.invoke(rent, args);

        return null;
    }

    public void seeHouse(){
        System.out.println("房东带你看房子");
    }
}
