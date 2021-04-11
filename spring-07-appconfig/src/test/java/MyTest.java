import com.wcx.config.MyConfig;
import com.wcx.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        User getUser = context.getBean("getUser", User.class);

        System.out.println(getUser.getName());

    }
}
