import com.spring.study.model.Users;
import com.spring.study.web.action.IUserAction;
import com.spring.study.web.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Haotian
 * @Date: 2019/11/29 15:15
 **/
public class SpringTest03 {

    @Test
    public void test1() {
        //web开发流程 action -> service -> dao
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans4.xml" );
        //拿到service
        IUserAction userAction = (IUserAction) context.getBean( "userAction" );

        //添加用户
        Users u = new Users();
        u.setUsername( "gyf" );
        u.setPassword( "1234" );
        userAction.register( u );
    }

    @Test
    public void test2() {
        //注解的使用
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans5.xml" );

        //拿到action
        UserAction userAction = (UserAction) context.getBean( "userAction" );

        //添加用户
        Users user = new Users();
        user.setUsername( "测试" );
        user.setPassword( "1234" );
        userAction.save( user );
    }
}
