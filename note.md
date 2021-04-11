## 常用依赖
```xml
<dependencies>
        <!-- 使用Spring-webmvc可以导入所有Spring相关的包 -->
        <!-- https://mvnrepository.com/artifact/org.springframework/springwebmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.5</version>
            <type>pom</type>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## beans.xml约束
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context.xsd">

    <!--    开启注解的支持-->
    <context:annotation-config/>
</beans>
```

## 注解说明
- @Autowired：自动装配，通过类型、名字
    如果@Autowired不能唯一自动装配，需要配合
    @Nullable
    @Qualifier(Value = xxx)
    
- @Component：组件，放在类上，这个类被Spring管理，相当于
              <bean id="user" class="com.wcx.pojo.User"/>

- @Resource ：自动装配，通过名字、类型

## 使用注解开发
- 在Spring4之后，要使用注解开发，必须保证AOP的包已经导入
- 使用之前导入context约束和注解支持

### 1. bean
@Component 相当于bean标签
### 2. 属性如何注入
@Value 相当于property标签
### 3. 衍生的注解
添加如下注解，表示被Spring托管，与@Component一样
- dao [@Repository]
- service [@Service]
- controller [@Controller]

## 使用Java的方式配置Spring
不使用xml配置Spring
JavaConfig是Spring的一个子项目

