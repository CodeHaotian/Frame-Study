import com.spring.study.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest01 {

    @Test
    public void test() {
       /* 以前用UserService方式,自己创建对象
        UserService service = new UserServiceImpl();
        service.add();*/

        //现在使用UserService方式从spring容器获取
        //Spring容器加载有3种方式,加载beans.xml 这个spring的配置文件,内部就会创建对象
        //第一种:ClassPathXmlApplicationContext ClassPath类路径加载，指的就是classes路径
        //第一种：最常用,spring的配置文件路径以后就直接放在src
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );

        //第二种方式：文件系统路径获得配置文件【绝对路径】
        //ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\10301\\Desktop\\IDEAWorkspace\\day02-spring-20180425\\src\\com\\gyf\\beans.xml");

        //第三种方式:使用BeanFactory(了解)
        //String path = "C:\\Users\\10301\\Desktop\\IDEAWorkspace\\day02-spring-20180425\\src\\com\\gyf\\beans.xml";
        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource(path));
        //UserService user = (UserService) factory.getBean("userService");
        //user.add();

        //2.从spring容器获取 userSerivce对象
        UserService service1 = (UserService) context.getBean( "userService" );
        //service1.add();
    }
}
