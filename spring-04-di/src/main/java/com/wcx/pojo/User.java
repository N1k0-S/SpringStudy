package com.wcx.pojo;

public class User {
    private String name;
    private int age;

    //c命名空间，对应的有参构造注入
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //p命名空间，对应的set方法注入,需要无参构造函数
    public User() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
