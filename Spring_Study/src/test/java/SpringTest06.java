import com.spring.study.model.User;
import com.spring.study.service.UserService;
import com.spring.study.service.impl.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest06 {

    @Test
    public void test1() {
        //获取Spring容器中代理对象
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans7.xml" );

        UserService userService = (UserService) context.getBean( "userService" );
        User user = new User();
        user.setUsername( "测试" );

        userService.add( user );

        StudentService ss = (StudentService) context.getBean( "studentService" );
        ss.add();
    }

    @Test
    public void test2() throws Exception {

        /**
         * 使用注解来配置AOP
         */
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans8.xml" );

        UserService userService = (UserService) context.getBean( "userService" );

        userService.delete();
    }
}
