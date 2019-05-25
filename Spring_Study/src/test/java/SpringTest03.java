import com.spring.study.model.Customer;
import com.spring.study.model.User;
import com.spring.study.service.UserService;
import com.spring.study.web.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest03 {

    @Test
    public void test1() {
        //web开发流程 action -> service -> dao
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans4.xml" );
        //拿到service
        UserService userService = (UserService) context.getBean( "userService" );

        //添加用户
        User user = new User();
        user.setUsername( "gyf" );
        user.setPassword( "1234" );
        userService.add( user );
    }

    @Test
    public void test2() {
        //注解的使用
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans5.xml" );

        //拿到action
        UserAction userAction = (UserAction) context.getBean( "userAction" );

        //添加用户
        User user = new User();
        user.setUsername( "测试" );
        user.setPassword( "1234" );
        userAction.save( user );
    }
}
