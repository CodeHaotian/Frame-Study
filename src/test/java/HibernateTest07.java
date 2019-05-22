import com.hibernate.domain.Customer;
import com.hibernate.domain.Order;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest07 {
    /**
     * 一对多数据保存
     */
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //1.创建客户对象
        Customer customer = new Customer();
        customer.setName( "陆生" );

        //2.创建订单
        Order order1 = new Order();
        order1.setName( "笔记本" );
        Order order2 = new Order();
        order2.setName( "手机" );

        //3.维护订单与客户关系
        order1.setCustomer( customer );
        order2.setCustomer( customer );

        //4.客户拥有订单
        customer.getOrders().add( order1 );
        customer.getOrders().add( order2 );

        //5.保存数据，xml中配置级联操作，自动进行数据关联
        session.save( customer );
        //session.save( order1 );
        //session.save( order2 );

        session.getTransaction().commit();
        session.close();
    }

    /**
     * 级联删除一对多
     * 删除A的同时，会删除B,先删除B,再删除A
     */
    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //1.获取客户
        Customer customer = (Customer) session.get( Customer.class, 2 );

        //2.删除
        session.delete( customer );

        session.getTransaction().commit();
        session.close();

    }

    /**
     * 级联孤儿删除:
     * 孤儿删除，解除关系，同时将B删除，A存在的。
     */
    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //1.获取客户
        Customer customer = (Customer) session.get( Customer.class, 1 );

        //2.孤儿删除(把客户里的所有定单移除)
        //不能用下面的两种方式移除定单,因为客户还不知道自己的定单
        //customer.setOrders(null);
        //customer.setOrders(new HashSet<Order>());

        //把订单从Customer的set集合删除
        Set<Order> orders = customer.getOrders();
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            iterator.next();//取出下一个元素
            iterator.remove();//移除当前元素
        }

        session.delete( customer );
        session.getTransaction().commit();
        session.close();
    }
}
