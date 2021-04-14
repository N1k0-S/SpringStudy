import com.wcx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //AOP原理是动态代理，代理的是接口
        UserService userService = context.getBean("userService", UserService.class);

        userService.insert();
    }
}
