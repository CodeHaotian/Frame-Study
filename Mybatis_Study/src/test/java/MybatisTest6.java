import com.mybatis.study.mapper.OrderMapper;
import com.mybatis.study.mapper.UserMapper;
import com.mybatis.study.model.Orders;
import com.mybatis.study.model.OrdersExt;
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
import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/27 16:37
 */
public class MybatisTest6 {
    SqlSession session;
    OrderMapper mapper;

    @Before
    public void before() throws IOException {
        System.out.println( "before.....获取session" );
        //读取配置文件
        InputStream is = Resources.getResourceAsStream( "SqlMapConfig.xml" );

        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build( is );

        //通过SqlSessionFactory创建SqlSession。
        session = sessionFactory.openSession();
        mapper = session.getMapper( OrderMapper.class );
    }

    @After
    public void after() {
        System.out.println( "after.....关闭session" );
        //关闭SqlSession。
        session.close();
    }

    /**
     * 一对一 : 写个定单的扩展类
     */
    @Test
    public void test1() {
        OrdersExt ordersExt = mapper.findOrderById( 3 );
        System.out.println( ordersExt );
    }

    /**
     * 一对一 : 模型里有模型
     */
    @Test
    public void test2() {
        Orders order = mapper.findOrderById2( 3 );
        System.out.println( order );
        System.out.println( order.getUser() );
    }

    /**
     * 一对多 : 模型里有集合
     */
    @Test
    public void test3() {
        Orders order = mapper.findOrderById3( 3 );
        System.out.println( order );
        System.out.println( order.getUser() );
        System.out.println( order.getOrderDetails() );
    }

    /**
     * 懒加载
     */
    @Test
    public void test4() {
        List<Orders> list = mapper.findOrderAndUserByLazyloading();
        for (Orders order : list) {
            System.out.println( "订单信息:" );
            System.out.println( order );

            System.out.println( "订单所属的客户:" );
            System.out.println( order.getUser() );
        }
    }
}
