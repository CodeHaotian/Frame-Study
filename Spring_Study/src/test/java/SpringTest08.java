import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 9:31
 * @Description: 数据源测试
 */
public class SpringTest08 {
    @Test
    public void c3p0Datasource() throws Exception {
        //测试c3p0连接
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass( "com.mysql.jdbc.Driver" );
        dataSource.setJdbcUrl( "jdbc:mysql://localhost:3306/demo?useSSL=false" );
        dataSource.setUser( "root" );
        dataSource.setPassword( "AngelBeats" );
        Connection connection = dataSource.getConnection();
        System.out.println( connection.toString() );
        connection.close();
    }

    @Test
    public void druidDatasource() throws Exception {
        //测试druid连接
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
        dataSource.setUrl( "jdbc:mysql://localhost:3306/demo?useSSL=false" );
        dataSource.setUsername( "root" );
        dataSource.setPassword( "AngelBeats" );
        Connection connection = dataSource.getConnection();
        System.out.println( connection.toString() );
        connection.close();
    }
}
