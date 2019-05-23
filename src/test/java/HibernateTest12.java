import com.hibernate.domain.Customer;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 * 测试连通性
 *
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest12 {

    @Test
    public void test1() {
        //查询缓存,针对hql
        Session session1 = HibernateUtils.openSession();
        Query query1 = session1.createQuery( "FROM Customer" );
        query1.setCacheable( true );//设置允许缓存
        System.out.println( query1.list() );

        //关闭session
        session1.close();

        //另一个session获取数据
        Session session2 = HibernateUtils.openSession();
        Query query2 = session2.createQuery( "FROM Customer" );
        query2.setCacheable( true );//设置允许缓存
        System.out.println( query2.list() );

        System.out.println( session2.get( Customer.class, 1 ) );//会执行sql语句不？
        session2.close();
    }

    @Test
    public void test2() {
        //时间戳缓存:记录你操作类型
        /**
         * select
         * update
         * select
         */
        Session session1 = HibernateUtils.openSession();
        session1.getTransaction().begin();

        //执行select sql
        Customer customer1 = (Customer) session1.get( Customer.class, 1 );
        System.out.println( customer1 );

        //customer1.setName("zzzzz");

        Query query = session1.createQuery( "update Customer set name =:name where id=:id" );
        query.setParameter( "name", "zzzzz" );
        query.setParameter( "id", 1 );
        query.executeUpdate();//执行upate

        //关闭session
        session1.getTransaction().commit();
        session1.close();

        //另一个session获取数据
        Session session2 = HibernateUtils.openSession();
        Customer customer2 = (Customer) session2.get( Customer.class, 1 );
        System.out.println( customer2 );
        session2.close();
    }
}
