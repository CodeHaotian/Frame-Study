import com.hibernate.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**测试连通性
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest01 {
    @Test
    public void test1() {
        //保存用户数据
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();

        /**
         * 添加表的映射文件方法：
         * 1.在hibernate.cfg.xml中配置mapping 【常用】
         * 2.调用Configuration对象addResource
         * 	cfg.addResource("com/gyf/hibernate/domain/User.hbm.xml");
         * 3.调用Configuration对象的addClass方法
         * 	cfg.addClass(User.class);
         */
        cfg.addClass( User.class );

        //2.创建会话工厂
        SessionFactory factory = cfg.buildSessionFactory();

        //3.创建会话【会话相当于连接Connect】
        Session sessoin = factory.openSession();

        //开启事务
        Transaction trans = sessoin.getTransaction();
        trans.begin();

        //保存【直接把对象保存到数据库】
        User user = new User();
        user.setUid( 3 );
        user.setUsername( "gyf05" );
        user.setPassword( "123" );
        sessoin.save( user );

        //提交事务
        trans.commit();
        //4.关闭会话
        sessoin.close();
        //5.关闭工厂，释放资源
        factory.close();
    }
}
