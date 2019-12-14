import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import static java.lang.System.out;

/**
 * @Author：Haotian
 * @Date：2019/5/27 16:37
 */
public class MybatisTest4 {
    SqlSession session;
    UserMapper userMapper;

    @Before
    public void before() throws IOException {
        out.println( "before.....获取session" );
        //读取配置文件
        InputStream is = Resources.getResourceAsStream( "SqlMapConfig.xml" );

        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build( is );

        //通过SqlSessionFactory创建SqlSession。
        session = sessionFactory.openSession( true );
        userMapper = session.getMapper( UserMapper.class );
    }

    @After
    public void after() {
        out.println( "after.....关闭session" );
        //关闭SqlSession。
        session.close();
    }

    @Test
    public void findOne() {
        //获取数据
        out.println( userMapper.findUserById( 1 ) );
    }

    @Test
    public void save() {
        //保存数据
        User user = User.builder().username( "admin" ).birthday( new Date() ).sex( "2" ).address( "测试" ).build();
        userMapper.save( user );
    }

    @Test
    public void test2() {
        //通过模型的包装类来查询用户
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setId( 1 );
        query.setUser( user );

        List<User> list = userMapper.findUserByUserQueryVo( query );
        out.println( list );
    }

    @Test
    public void test3() {
        //查询条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "username", "张" );
        map.put( "sex", "1" );

        List<User> list = userMapper.findUserByMap( map );
        out.println( list );
    }

    @Test
    public void findAll() {
        //设置分页条件
        PageHelper.startPage( 1, 4 );
        List<User> list = userMapper.findAll();
        list.forEach( out::print );
        //获取分页数据
        PageInfo<User> pageInfo = new PageInfo<User>( list );
        out.println( "总条数：" + pageInfo.getTotal() );
        out.println( "总页数：" + pageInfo.getPages() );
        out.println( "当前页：" + pageInfo.getPageNum() );
        out.println( "每页显示条数：" + pageInfo.getPageSize() );
        out.println( "是否为第一页：" + pageInfo.isIsFirstPage() );
        out.println( "是否为最后一页：" + pageInfo.isIsLastPage() );
    }
}