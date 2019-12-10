import com.mybatis.study.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static java.lang.System.*;

/**
 * @Author: Haotian
 * @Date: 2019/12/10 13:46
 * @Description: mybatis crud
 **/
public class MybatisTest2 {
    SqlSession session;

    @Before
    public void before() throws IOException {
        out.println( "before.....获取session" );
        //读取配置文件
        InputStream is = Resources.getResourceAsStream( "SqlMapConfig.xml" );

        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build( is );

        //通过SqlSessionFactory创建SqlSession。
        session = sessionFactory.openSession( true );
    }

    @After
    public void after() {
        out.println( "after.....关闭session" );
        //关闭SqlSession。
        session.close();
    }

    /**
     * 查询：一条记录和多条记录
     */
    @Test
    public void find() {
        //调用SqlSession的操作数据库方法。
        //查询一条结果
        User user = session.selectOne( "findUserById", 10 );
        out.println( user );

        //查询多条结果
        List<User> users = session.selectList( "findUserByName", "张" );
        Assert.assertEquals( 3, users.size() );
        users.forEach( out::println );
    }

    /**
     * 插入数据
     */
    @Test
    public void save() {
        User user = User.builder().username( "admin" ).sex( "女" ).birthday( new Date() ).address( "广州" ).build();
        int affectRow = session.insert( "insertUser", user );
        //session.commit();//事务
        out.println( "受影响的行数:" + affectRow );
    }

    //删除用户
    @Test
    public void delete() {
        int affectRow = session.delete( "deleteUser", 47 );
        out.println( "受影响的行数:" + affectRow );
    }

    //更新用户信息
    @Test
    public void update() {
        User user = User.builder().id( 27 ).sex( "女" ).address( "香港" ).build();
        int affectRow = session.update( "updateUser", user );
        out.println( "受影响的行数:" + affectRow );
    }

    /**
     * 插入后，往模型里设置id
     */
    @Test
    public void test5() {
        User user = User.builder().username( "test" ).sex( "2" ).birthday( new Date() ).address( "广州" ).build();
        int affectRow = session.insert( "insertUserAndReturnId", user );
        out.println( "受影响的行数:" + affectRow );
        out.println( "用户的ID:" + user.getId() );
    }
}