import com.mybatis.study.dao.UserDao;
import com.mybatis.study.dao.impl.UserDaoImpl;
import com.mybatis.study.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/27 16:37
 */
public class MybatisTest3 {
    SqlSessionFactory sessionFactory;

    @Before
    public void before() throws IOException {
        System.out.println( "before.....获取session" );
        //读取配置文件
        InputStream is = Resources.getResourceAsStream( "SqlMapConfig.xml" );

        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        sessionFactory = new SqlSessionFactoryBuilder().build( is );

    }

    @Test
    public void test1() {

        //调用dao
        //1.创建dao
        UserDao userDao = new UserDaoImpl( sessionFactory );

        User user1 = userDao.findUserById( 1 );

        System.out.println( user1 );

//        User user2 = new User( "xxx", "x", new Date(), "xx" );
//        userDao.save( user2 );
    }
}
