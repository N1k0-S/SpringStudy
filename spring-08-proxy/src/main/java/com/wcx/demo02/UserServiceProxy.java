package com.wcx.demo02;


public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Override
    public void insert() {
        log("insert");
        userService.insert();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void select() {
        log("select");
        userService.select();
    }

    //打印日志方法
    public void log(String Msg){
        System.out.println("[Debug]使用了"+Msg+"方法");
    }
}
