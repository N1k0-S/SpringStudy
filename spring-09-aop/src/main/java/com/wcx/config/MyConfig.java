//package com.wcx.config;
//
//import com.wcx.log.AfterLog;
//import com.wcx.log.Log;
//import com.wcx.service.UserServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ComponentScan("com.wcx.log")
//@ComponentScan("com.wcx.service")
//public class MyConfig {
//
//    @Bean
//    public UserServiceImpl userService() {
//        return new UserServiceImpl();
//    }
//
//    @Bean
//    public Log log(){
//        return new Log();
//    }
//
//    @Bean
//    public AfterLog afterLog(){
//        return new AfterLog();
//    }
//}
