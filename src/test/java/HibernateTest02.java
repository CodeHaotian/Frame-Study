import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 测试session的特性
 *
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest02 {
    @Test
    public void test1() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        SessionFactory factory = cfg.buildSessionFactory();

	    /*sessionFactory提供了两个方法来获取session
		1.factory.openSession() 获取一个全新的session
		2.factory.getCurrentSession() 获取一个与当前线程绑定的session*/
        Session session1 = factory.openSession();
        Session session2 = factory.openSession();
        System.out.println( session1.hashCode() );
        System.out.println( session2.hashCode() );

        Session session3 = factory.getCurrentSession();
        Session session4 = factory.getCurrentSession();
        System.out.println( session3.hashCode() );
        System.out.println( session4.hashCode() );

        new Thread( () -> {
            Session session5 = factory.getCurrentSession();
            Session session6 = factory.getCurrentSession();
            System.out.println( session5.hashCode() );
            System.out.println( session6.hashCode() );
        } ).start();

        //4.关闭会话
        //如果是通过open方法打开session,要自己关闭
        session1.close();
        session2.close();
        //如果是通过get方法获取session，session不需要关闭，因为事务提交或者回滚会自动关闭

        //5.关闭工厂，释放资源
        factory.close();
    }
}
