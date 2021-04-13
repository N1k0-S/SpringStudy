package com.wcx.demo03;

class Client {
    public static void main(String[] args) {

        //真实角色
        Host host = new Host();

        //代理角色：通过处理程序生成代理类
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(host);

        //proxy 即为代理类
        Rent proxy = (Rent) pih.getProxy();

        proxy.rent();
    }
}
