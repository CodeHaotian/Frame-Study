import com.spring.study.model.User;
import com.spring.study.model.Users;
import com.spring.study.service.UserService;
import com.spring.study.service.impl.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest05 {

    @Test
    public void test1() {
        //获取Spring容器中代理对象
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans6.xml" );

        UserService userService = (UserService) context.getBean( "userService" );
        Users user = new Users();
        user.setUsername( "测试" );

        userService.add( user );

        StudentService ss = (StudentService) context.getBean( "studentService" );
        ss.add();
    }


}
