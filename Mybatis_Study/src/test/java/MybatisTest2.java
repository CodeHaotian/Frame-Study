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
public class MybatisTest2 {
    SqlSession session;

    @Before
    public void before() throws IOException {
        System.out.println( "before.....获取session" );
        //读取配置文件
        InputStream is = Resources.getResourceAsStream( "SqlMapConfig.xml" );

        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build( is );

        //通过SqlSessionFactory创建SqlSession。
        session = sessionFactory.openSession();
    }

    @After
    public void after() {
        System.out.println( "after.....关闭session" );
        //关闭SqlSession。
        session.close();
    }

    /**
     * 查询：一条记录和多条记录
     *
     * @throws IOException
     */
    @Test
    public void test1() {
        //调用SqlSession的操作数据库方法。
        //查询一条结果
        User user = session.selectOne( "findUserById", 10 );
        System.out.println( user );

        //查询多条结果
        List<User> users = session.selectList( "findUserByName", "张" );
        System.out.println( users );
    }

    /**
     * 插入数据
     *
     * @throws IOException
     */
    @Test
    public void test2() {
        User user = new User( "linlin", "2", new Date(), "广州" );
        int affectRow = session.insert( "insertUser", user );
        session.commit();//事务
        System.out.println( "受影响的行数:" + affectRow );
    }

    //删除用户
    @Test
    public void test3() {
        int affectRow = session.delete( "deleteUser", 44 );
        session.commit();//事务
        System.out.println( "受影响的行数:" + affectRow );
    }

    //更新用户
    @Test
    public void test4() {
        User user = new User();
        user.setId( 27 );
        user.setSex( "女" );
        user.setAddress( "深圳" );
        int affectRow = session.update( "updateUser", user );
        session.commit();//事务
        System.out.println( "受影响的行数:" + affectRow );
    }

    /**
     * 插入后，往模型里设置id
     *
     * @throws IOException
     */
    @Test
    public void test5() {
        User user = new User( "test", "2", new Date(), "广州" );
        int affectRow = session.insert( "insertUser2", user );
        session.commit();//事务
        System.out.println( "受影响的行数:" + affectRow );
        System.out.println( "用户的ID:" + user.getId() );
    }
}
