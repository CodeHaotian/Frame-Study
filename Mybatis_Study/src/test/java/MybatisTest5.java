import com.mybatis.study.mapper.UserMapper;
import com.mybatis.study.model.OrderDetail;
import com.mybatis.study.model.Orders;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：Haotian
 * @Date：2019/5/27 16:37
 */
public class MybatisTest5 {
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
        //通过模型的包装类来查询
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setSex( "1" );//男性
        query.setUser( user );
        int count = userMapper.findUserCount( query );
        System.out.println( "男性的用户人数:" + count );
    }

    /**
     * 结果类型resultMap
     */
    @Test
    public void test2() {
        User user = userMapper.findUserByIdResultMap( 1 );
        System.out.println( "用户数据:" + user );
    }

    /**
     * if和where讲解
     */
    @Test
    public void test3() {
        //查询条件
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setSex( "1" );//男性
        user.setUsername( "张" );
        query.setUser( user );

        List<User> users = userMapper.findUserList( query );
        System.out.println( users );
    }

    /**
     * if和where使用foreach遍历id查询
     */
    @Test
    public void test4() {
        UserQueryVO query = new UserQueryVO();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add( 1 );
        ids.add( 10 );
        ids.add( 16 );
        query.setIds( ids );
        List<User> users = userMapper.findUserByIds( query );
        System.out.println( users );
    }

    /**
     * if和where使用foreach遍历id查询，改用数组方式
     */
    @Test
    public void test5() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add( 1 );
        ids.add( 10 );
        ids.add( 16 );
        List<User> users = userMapper.findUserByIds2( ids );
        System.out.println( users );
    }

    /**
     * 多对多
     */
    @Test
    public void test6() {
        List<User> users = userMapper.findUserAndOrderInfo();
        for (User user : users) {
            System.out.println( "用户信息:" + user );
            for (Orders order : user.getOrderList()) {
                System.out.println( "定单信息:" + order );
                System.out.println( "订单详情:" );
                for (OrderDetail od : order.getOrderDetails()) {
                    System.out.println( od + ":" + od.getItems() );
                }
                System.out.println( "------------------------------" );
            }
        }
    }
}
