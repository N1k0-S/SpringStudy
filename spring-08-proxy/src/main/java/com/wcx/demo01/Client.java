package com.wcx.demo01;

public class Client {
    public static void main(String[] args) {

        Host host = new Host();
        //代理
        Proxy proxy = new Proxy(host);

        /**
         * 经过代理之后，可以不用访问房东
         */
        proxy.seeHouse();
        proxy.rent();

    }
}
