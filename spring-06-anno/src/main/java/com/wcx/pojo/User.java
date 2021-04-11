package com.wcx.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @Component 注解相当于<bean id="user" class="com.wcx.pojo.User"/>
 * @Component 组件
 */
@Component
public class User {

    @Value("Niko")
    public String name;
}
