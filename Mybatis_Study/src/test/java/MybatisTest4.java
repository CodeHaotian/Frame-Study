import com.mybatis.study.mapper.UserMapper;
import com.mybatis.study.model.User;
import com.mybatis.study.vo.UserQueryVO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：Haotian
 * @Date：2019/5/27 16:37
 */
public class MybatisTest4 {
    SqlSession session;
    UserMapper userMapper;

    @Before
    public void before() throws IOException {
        System.out.println( "before.....获取session" );
        //读取配置文件
        InputStream is = Resources.getResourceAsStream( "SqlMapConfig.xml" );

        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build( is );

        //通过SqlSessionFactory创建SqlSession。
        session = sessionFactory.openSession();
        userMapper = session.getMapper( UserMapper.class );
    }

    @After
    public void after() {
        System.out.println( "after.....关闭session" );
        //关闭SqlSession。
        session.close();
    }

    @Test
    public void test1() {
        //UserMapper userMapper=session.getMapper( UserMapper.class );
        //System.out.println(obj.getClass());
        //获取数据
        System.out.println( userMapper.findUserById( 1 ) );
        //保存
        /*User user2 = new User("xxx","x",new Date(),"xx");
        userMapper.save(user2);
        session.commit();*/
    }

    @Test
    public void test2() {
        //通过模型的包装类来查询用户
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setId( 1 );
        query.setUser( user );

        List<User> list = userMapper.findUserByUserQueryVo( query );
        System.out.println( list );
    }

    @Test
    public void test3() {
        //查询条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "username", "张" );
        map.put( "sex", "1" );

        List<User> list = userMapper.findUserByMap( map );
        System.out.println( list );
    }
}
