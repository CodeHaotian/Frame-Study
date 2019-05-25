import com.spring.study.model.Customer;
import com.spring.study.model.User;
import com.spring.study.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest02 {

    @Test
    public void test1() throws Exception {
        //Bean的生命周期
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans2.xml" );

        User user = (User) context.getBean( "user" );

        System.out.println( user );

        //关闭容器
        context.getClass().getMethod( "close" ).invoke( context );
    }

    @Test
    public void test2() {
        /**
         * SpEL:spring表达式
         */
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans3.xml" );

        Customer customer = (Customer) context.getBean( "customer" );
        System.out.println( customer );

        System.out.println( customer.getAddress() );
    }
}
