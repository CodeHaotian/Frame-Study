import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest05 {
    @Test
    public void test1() {

        //实体类entity（model）的编写规则
        //1.必须要提供无参的构造方法,获取数据封装模型会调用无参的构造方法
        //2.提供一个标识属性，映射数据表主键字段，提供id
        //3.所有属性提供public访问控制符的 set  get 方法(javaBean)
        //4.标识属性应尽量使用基本数据类型的包装类型
        //5.不要用final修饰实体 （将无法生成代理对象进行优化）
        Session session = HibernateUtils.openSession();
        User user = session.get( User.class, 2 );
        System.out.println( user );
    }

    @Test
    public void test2() {
        //主键的生成策略
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        User user = new User();
        user.setUsername( "linlin" );
        //user.setUid(UUID.randomUUID().toString().replace("-",""));
        session.save( user );
        session.getTransaction().commit();
        session.close();
    }
}
