import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;


/**
 * Criteria 对象学习
 * QBC（query by criteria），hibernate提供纯面向对象查询语言，
 * 提供直接使用PO对象进行操作
 *
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest04 {
    @Test
    public void test1() {
        //1.获取核心 配置文件对象
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        SessionFactory factory = cfg.buildSessionFactory();

        //3.通过会话工厂获取session对象
        Session session = factory.openSession();

        //查询对象
        //创建Criteria查询对象
        Criteria criteria = session.createCriteria( User.class );

        /**加条件
         * eq =
         * 【lt 小于>】【 le小于等于>=】
         * 【gt 大于>】【 ge大于等于>=】
         */
        //criteria.add(Restrictions.eq("username", "admin"));
        //criteria.add(Restrictions.eq("password", "123"));
        //System.out.println(criteria.uniqueResult());

        criteria.add( Restrictions.ge( "uid", 2 ) );
        List<User> list = criteria.list();
        for (User user : list) {
            System.out.println( user );
        }

        // 【模糊查询】
        System.out.println( criteria.add( Restrictions.like( "username", "%琳%" ) ) );

        //4.关闭会话
        session.close();

        //5.关闭工厂，释放资源
        factory.close();
    }

    /**
     * SQLQuery
     * SQLQuery:使用原生的SQL语句查询
     * 并不是所有sql都能转成hql
     */
    @Test
    public void test2() {
        //获取session对象
        Session session = HibernateUtils.openSession();

        //创建SQLQuery查询对象
        SQLQuery query = session.createSQLQuery( "select * from hibernate_user" );

        //返回数据封装到集合，集合装的数组
        List<Object[]> list = query.list();
        for (Object[] objs : list) {
            for (Object o : objs) {
                System.out.println( o );
            }
            System.out.println( "-------------------" );
        }

        //关闭会话
        session.close();
    }
}
