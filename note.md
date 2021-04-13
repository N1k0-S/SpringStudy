## 1、常用依赖
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

## 2 、beans.xml约束
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

## 3、注解说明
- @Autowired：自动装配，通过类型、名字
    如果@Autowired不能唯一自动装配，需要配合
    @Nullable
    @Qualifier(Value = xxx)
    
- @Component：组件，放在类上，这个类被Spring管理，相当于
              <bean id="user" class="com.wcx.pojo.User"/>

- @Resource ：自动装配，通过名字、类型

## 4、使用注解开发
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

## 5、使用Java的方式配置Spring
不使用xml配置Spring
JavaConfig是Spring的一个子项目

- @Configuration  

  用于代替xml配置Spring，注解本身也会被Spring托管，注册到容器中

  加上注解后，就相当于beans.xml，作为一个配置类

  ```text
  @Documented
  @Component
  public @interface Configuration {
      @AliasFor(
          annotation = Component.class
      )
  ```

代码示例：（MyConfig.class）

```java
@Configuration
@ComponentScan("com.wcx.pojo")
public class MyConfig {

    // 注册一个bean，相当于之前写的<bean></bean>
    // 方法的名字，相当于之前标签中的id属性
    // 方法的返回值，相当于之前标签中的class属性
    @Bean
    public User getUser(){
        return new User();
    }
}
```

## 10、代理模式

SpringAOP的底层 [SpringAOP、SpringMVC]

##### 代理模式的分类：

- 静态代理
- 动态代理



##### 代理模式的好处：

- 可以使真实角色的操作更加存粹，不需要去关注公共业务的发生
- 公共业务的操作交给代理角色
- 公共业务发生扩展时，方便集中管理



#### 10.2  动态代理

- 动态代理和静态代理的角色是相同的
- 动态代理的代理类是自动生成的
- 动态代理分为两大类：基于接口的动态代理，基于类的动态代理
  - 基于接口---JDK动态代理
  - 基于类：cglib
  - Java字节码：Javasist



