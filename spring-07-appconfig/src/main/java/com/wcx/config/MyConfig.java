package com.wcx.config;

import com.wcx.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Configuration 相当于配了<beans></beans>
 */
@Configuration
@ComponentScan("com.wcx.pojo")
// 将多个Config配置文件，合并成一个
@Import(MyConfig2.class)

public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
