import com.hibernate.domain.Customer;
import com.hibernate.domain.Student;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/23 15:07
 */
public class HibernateTest09 {
    //排序
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        //ID降序排序与sql order by
        List<Student> list = session.createQuery( "from Student s order by s.sid desc " ).list();
        for (Student s : list) {
            System.out.println( s );
        }
        session.close();
    }

    /**
     * 聚合函数和分组查询
     */
    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();

        //聚合函数 count
		/*Query query =  session.createQuery("select count(*) FROM Customer c");
		Long count = (Long) query.uniqueResult();
		System.out.println("客户表的总记录数据:" + count);*/

        //聚合函数 avg
		/*Query query =  session.createQuery("select avg(c.id) FROM Customer c");
		Double avg = (Double) query.uniqueResult();*/

        //HQL分组 group by
		/*#根据客户分组，查看有多少定单
		SELECT o.customer_id,COUNT(o.customer_id) FROM t_order o GROUP BY o.customer_id;*/

        List<Object[]> list = session.createQuery( "select o.customer,count(o) from Order o GROUP BY o.customer" ).list();

        for (Object[] objs : list) {

            for (Object obj : objs) {
                System.out.println( obj );
            }
            System.out.println( "------------------" );
        }
        session.close();
    }

    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        //1.HQL的交叉连接=笛卡尔集
        //List<Object[]> list = session.createQuery("FROM Customer c,Order o").list();

        //2.隐式内连接【join】,相当于在笛卡尔集加了过滤条件
        //List<Object[]> list = session.createQuery("FROM Customer c,Order o where c = o.customer").list();

        //3.内连接【inner join】,返回的数据封闭到数组 Object[] objs = {Customer,Order}
        //List<Object[]> list = session.createQuery("FROM Customer c inner join c.orders").list();

        //5.左外连接【left outer join】左表中如果没有右表的匹配数据，左表记录也会显示
        //List<Object[]> list = session.createQuery("FROM Customer c left outer join c.orders").list();

        //7.右外连接【left outer join】右表中如果没有左表的匹配数据，右表记录也会显示
        List<Object[]> list = session.createQuery( "FROM Customer c right outer join c.orders" ).list();
        for (Object[] objs : list) {
            System.out.println( objs[0] + ":" + objs[1] );
        }
        session.close();
    }

    @Test
    public void test4() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        //4.迫切内连接【inner join】,返回的数据是List<Customer>
        //List<Customer> list = session.createQuery("FROM Customer c inner join fetch c.orders").list();

        //6.迫切左外连接【left outer join】
        List<Customer> list = session.createQuery( "FROM Customer c left outer join fetch c.orders" ).list();

        for (Customer c : list) {
            System.out.println( c + "-" + c.getOrders() );
        }
        session.close();
    }
}
