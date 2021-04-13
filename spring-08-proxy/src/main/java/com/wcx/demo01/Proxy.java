package com.wcx.demo01;

//中介
public class Proxy implements Rent{

    /**
     * 优先采用组合的方式，不让中介继承房东的属性和方法
     */
    private Host host;

    public Proxy(){
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }

    /**
     * 某些只属于中介的功能
     */
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
}
