import com.hibernate.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;


/**
 * 分页查询
 *
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest03 {
    @Test
    public void test1() {
        //用户数据
        //1.获取核心 配置文件对象
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        SessionFactory factory = cfg.buildSessionFactory();

        //3.通过会话工厂获取session对象
        Session session = factory.openSession();

        //创建查询对象
        //sql:select * from t_user where username='gyf' and password = '123';
        //hql:面向对象的查询语言
        Query query = session.createQuery( "from User where username=? and password=?" );
        query.setParameter( 0, "admin" );
        query.setParameter( 1, "123" );

        //执行查询
        User user = (User) query.uniqueResult();
        System.out.println( user );

        //4.关闭会话
        session.close();

        //5.关闭工厂，释放资源
        factory.close();
    }

    @Test
    public void test2() {
        //1.获取核心 配置文件对象
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        SessionFactory factory = cfg.buildSessionFactory();

        //3.通过会话工厂获取session对象
        Session session = factory.openSession();

        //查询对象
        Query query = session.createQuery( "from User" );

        //分页查询 limit?,? 【limit 3,3】
        query.setFirstResult( 1 );//启始位置
        query.setMaxResults( 3 );//返回的数据条数

        //返回多行数据
        List<User> list = query.list();
        for (User obj : list) {
            System.out.println( obj );
        }
        //query.list() 返回多行数据
        //query.uniqueResult 返回一行数据

        //4.关闭会话
        session.close();

        //5.关闭工厂，释放资源
        factory.close();
    }
}
