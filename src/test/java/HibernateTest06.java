import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest06 {
    /**
     * save方法和persist方法有区别
     * 1.save和persist方法持久化，保存数据到数据库
     * 2.save中的对象可以设置id,保存时会忽略
     * 3.persist中的对象不可以设置id,设置id就会报错
     */
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();

		/*save方法：瞬时态 转换 持久态 ,会初始化OID
		1.执行save方法，立即触发insert语句，从数据库获得主键的值（OID值）
		2.执行save方法前，设置OID将忽略。
		3.如果执行查询，session缓存移除了，在执行save方法，将执行insert*/
        session.getTransaction().begin();

        User user = new User();//瞬时态
        user.setUid( 13 );
        System.out.println( user );

        session.save( user );//持久态
        System.out.println( user );

        session.clear();//user脱管状态
        session.save( user );

        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();

		/*persist方法：瞬时态 转换 持久态
			1.persist保存的对象，在保存前，不能设置id,否则会报错
			2.save和persist都是持久化对象的作用
			  save 因为需要返回一个主键值，因此会立即执行 insert 语句，
			  而 persist 在事务外部调用时则不会立即执行 insert 语句，
			 在事务内调用还是会立即执行 insert 语句的。*/

        session.getTransaction().begin();

        User user = new User();//瞬时态
        //user.setUid(30);
        session.persist( user );

        session.getTransaction().commit();
        session.close();

    }
}
