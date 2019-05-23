import com.hibernate.domain.Address;
import com.hibernate.domain.Company;
import com.hibernate.domain.Customer;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 * 一对一 测试连通性
 *
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest11 {
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        Company company1 = new Company();
        company1.setName( "新纪元" );

        Address address1 = new Address();
        address1.setName( "独立地" );

        address1.setCompany( company1 );

        session.save( address1 );

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //读公司
        Company company = (Company) session.get( Company.class, 1 );

        //打印公司名称
        System.out.println( company.getName() );

        //打印公司的地址
        System.out.println( company.getAddress().getName() );

        session.getTransaction().commit();
        session.close();
    }
}
