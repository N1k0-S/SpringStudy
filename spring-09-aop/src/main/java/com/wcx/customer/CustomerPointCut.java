package com.wcx.customer;

public class CustomerPointCut {

    public void before(){
        System.out.println("=====方法执行前=====");
    }

    public void after(){
        System.out.println("=====方法执行后=====");
    }
}
