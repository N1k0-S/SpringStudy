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

- @Resource ：自动装配，通过名字、类型