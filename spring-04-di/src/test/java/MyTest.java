import com.wcx.pojo.Address;
import com.wcx.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //通过Bean的方式已经新建好对应的类，并且通过Property进行赋值
        Address address = (Address)context.getBean("address");
        Student student = (Student)context.getBean("student");

        System.out.println(student.getName());

        /**
         * 不需要student.setAddress(address);
         * 通过set方式的依赖注入
         * set方法已经将address（引用类型）注入到student类中
         * student.setAddress(address);
         */

        System.out.println(student);
        /**
         * Student{name='Niko',
         *         address=Address{address='BeiJing DongCheng District'},
         *         books=[红楼梦, 西游记, 水浒传, 三国演义],
         *         hobby=[听歌, 看电影, 打篮球],
         *         card={身份证=123456789,
         *               护照号=987654321
         *              },
         *         game=[LOL, CS:GO],
         *         wife='null',
         *         info={sex=male,
         *               idNo=20190525
         *              }
         *        }
         */
    }
}
