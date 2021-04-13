package com.wcx.demo04;

public class Client {
    public static void main(String[] args) {

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userServiceImpl);

        UserService userService = (UserService) pih.getProxy();

        userService.insert();
    }
}
