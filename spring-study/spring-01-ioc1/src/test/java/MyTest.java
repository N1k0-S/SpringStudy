import com.wcx.dao.UserDaoMysqlImpl;
import com.wcx.service.UserService;
import com.wcx.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        /**
         *  自己创建对象的方式
         UserService userService = new UserServiceImpl();

         ((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());

         userService.getUser();

         UserServiceImpl userService = new UserServiceImpl();

         userService.setUserDao(new UserDaoMysqlImpl());

         userService.getUser();
         **/

        //获取ApplicationContext(cpx:ClassPathXmlApplicationContext)
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        /**
         * Spring已经创建好了UserServiceImpl对象
         * 并且已经set好了对应的内容
         */
        UserServiceImpl userService = (UserServiceImpl)context.getBean("serviceImpl");
        userService.getUser();
    }
}
