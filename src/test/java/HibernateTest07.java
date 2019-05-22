import com.hibernate.domain.Customer;
import com.hibernate.domain.Order;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest07 {
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

        //5.保存数据
        session.save( customer );
        session.save( order1 );
        session.save( order2 );

        session.getTransaction().commit();
        session.close();
    }
}
