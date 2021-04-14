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



#### 10.2  动态代理（reflect）

- 动态代理和静态代理的角色是相同的
- 动态代理的代理类是自动生成的
- 动态代理分为两大类：基于接口的动态代理，基于类的动态代理
  - 基于接口---JDK动态代理
  - 基于类：cglib
  - Java字节码：Javasist

两个使用到的类：Proxy 代理，InvocationHandler 调用处理程序

##### 10.2.1 动态代理两个步骤：

- 生成代理类：

```java
public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }
```

```java
public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h){
    
}
```

newProxyInstance(加载类所在位置，代理的接口是哪个，InvovationHandler)



- invoke负责执行方法

```java
@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的机制就是使用反射机制实现
        Object result = method.invoke(rent, args);
        return null;
```



**总结**

动态代理生成类，可以归结为如下通用方法：

```java
	private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //此处可以使用反射中的method方法，获取对应想要的方法
        Object result = method.invoke(target, args);

        return null;
    }
```



## 11、使用Spring实现AOP

#### 11.1 使用Spring的API接口

需要在applicationcontext.xml中配置

```xml
        方式一：使用原生Spring API接口
        配置AOP：需要导入aop的约束
        <aop:config>
            <!--        切入点:expression:表达式， execution(要执行的位置)-->
            <aop:pointcut id="pointcut" expression="execution(* com.wcx.service.UserServiceImpl.*(..))"/>

            <!--        执行环绕增加-->
            <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
            <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
        </aop:config>
```

配置切入点，通过表达式，确定要切入的 类---方法---参数，之后将写好的方法（实现原生的API接口），通过切入点确认方法使用位置。

- 个人理解

  ```xml
  <aop:pointcut id="pointcut" expression="execution(* com.wcx.service.UserServiceImpl.*(..))"/>
  ```

  和动态代理类似，将想要代理的方法作为切点生成，之后的Log等操作，就是代理类提供的方法

##### 11.1.1 execution表达式

| 符号                            | 含义                                                 |
| ------------------------------- | ---------------------------------------------------- |
| 执行（）                        | 表达式的主体;                                        |
| 第一个” *“符号                  | 表示返回值的类型任意;                                |
| com.wcx.service.UserServiceImpl | AOP所切的服务的包名                                  |
| 包名后面的” ..“                 | 表示当前包及子包                                     |
| 第二个” *“                      | 表示类名                                             |
| .*（..）                        | 表示任何方法名，括号表示参数，两个点表示任何参数类型 |



#### 11.2 自定义类实现AOP

自定义类实现AOP，将自定义类定义为切面，自定义类中的方法在代理方法哪个位置实现由AOP控制

```xml
    <aop:config>
        <!--        自定义切面，ref为要引用的类-->
        <aop:aspect ref="customer">
            <aop:pointcut id="pointcut" expression="execution(* com.wcx.service.UserServiceImpl.*(..))"/>
            <aop:before method="before" pointcut-ref="pointcut"/>
            <aop:after-returning method="after" pointcut-ref="pointcut"/>
        </aop:aspect>
    </aop:config>
```



#### 11.3 使用注解实现



