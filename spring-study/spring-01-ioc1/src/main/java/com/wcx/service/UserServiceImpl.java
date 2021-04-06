package com.wcx.service;

import com.wcx.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    /**
     * 组合模式，将DAO层代码引入进来
     * 想实现别的类，需要改变这里引入的UserDaoImpl(控制反转核心思想）
     * 现在的写法，用户需求可能会影响到源代码，需要根据需求修改代码
     * private UserDao userDao = new UserDaoImpl();
     **/

    /**
     * 解决方法利用set方法实现值得注入
     *     public void setUserDao(UserDao userDao) {
     *         this.userDao = userDao;
     */

    /**
     * 之前由程序员创建对象，控制权在自己，需求变动影响代码变动
     * 使用set注入后，程序不具有主动性，被动的接收对象
     * 程序员不再管理对象的创建，降低系统耦合性，专注业务代码的实现
     * set接口（控制反转）是IOC的原型
     */

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {

        //Service层调用DAO层方法
        userDao.getUser();

    }
}
