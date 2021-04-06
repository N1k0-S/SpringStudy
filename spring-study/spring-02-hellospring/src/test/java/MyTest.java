import com.wcx.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        //获取Spring上下文对象，传入的参数为配置文件，可以为多个
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        /**
         * 现在对象都在Spring中管理，要使用，直接在Spring中获取
         * context.getBean返回的是对象
         */
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
