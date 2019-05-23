import com.hibernate.domain.Customer;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 * 测试连通性
 *
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest10 {
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //Hibernate的写锁/排他锁实现
        /**
         * 演示客户名，查找id为1
         * A线程【命令行】，开启事务->读取一行数据加锁
         * B线程【应用程序】，开启事务->读取一行数据加锁
         */

        //执行sql语句，使用写锁
		/*Customer customer = (Customer) session.get(Customer.class,1, LockOptions.UPGRADE);
		System.out.println(customer);*/
        /**
         * HQL的from后面不能写for update
         * 调用query.setLockOptions(LockOptions.UPGRADE);
         */
        Query query = session.createQuery( "from Customer where id=?" );
        query.setLockOptions( LockOptions.UPGRADE );
        query.setParameter( 0, 1 );

        Customer customer = (Customer) query.uniqueResult();
        System.out.println( customer );

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //Hibernate的写锁/排他锁实现
        /**
         * 演示客户名，查找id为1
         * A线程【命令行】，开启事务->读新一行数据加锁
         * B线程【应用程序】，开启事务->更新一行数据
         * 	更新时就不用写query.setLockOptions(LockOptions.UPGRADE);
         */
        //写更新hql
        Query query = session.createQuery( "update Customer set name=? where id=?" );
        query.setParameter( 0, "eee" );
        query.setParameter( 1, 1 );
        query.executeUpdate();//执行hql

        session.getTransaction().commit();
        session.close();
    }
}
