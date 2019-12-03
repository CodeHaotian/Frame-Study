import com.spring.study.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:43
 */
public class SpringTest07 {
    //转账测试
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans9.xml" );
        AccountService accountService = (AccountService) context.getBean( "accountService" );
        accountService.transfer( "艾莉丝", "杰米", 1000 );
    }
    //转账测试半自动
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans10.xml" );
        AccountService accountService = (AccountService) context.getBean( "proxyService" );
        accountService.transfer( "艾莉丝", "杰米", 500 );
    }
}
