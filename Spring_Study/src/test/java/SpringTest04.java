import com.spring.study.factory.MyBeanFactory;
import com.spring.study.model.User;
import com.spring.study.model.Users;
import com.spring.study.service.UserService;
import com.spring.study.service.impl.StudentService;
import org.junit.Test;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest04 {

    @Test
    public void test1() {
        //自己实现AOP编程，使用JDK代理来实现

        UserService userService = MyBeanFactory.createUserService();
        Users user = new Users();
        user.setUsername( "aaa" );
        userService.add( user );
    }

    @Test
    public void test2() {
        //实现AOP编程，使用cglib代理来实现

        StudentService ss = MyBeanFactory.createStudentService();

        ss.delete();
        ss.update();
        ss.add();
    }

}
