import com.hibernate.domain.Course;
import com.hibernate.domain.Customer;
import com.hibernate.domain.Order;
import com.hibernate.domain.Student;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/21 18:32
 */
public class HibernateTest08 {
    @Test
    public void test1() {
        /**
         * 保存多对多数据
         */
        Session session = HibernateUtils.openSession();

        session.getTransaction().begin();

        //1.创建2个学生
        Student stu1 = new Student();
        stu1.setName( "蕾姆" );
        Student stu2 = new Student();
        stu2.setName( "伊卡洛斯" );

        //2.创建2个课程
        Course c1 = new Course();
        c1.setName( "家政课" );
        Course c2 = new Course();
        c2.setName( "战斗学" );

        //3.绑定课程到学生
        stu1.getCourses().add( c1 );
        stu1.getCourses().add( c2 );

        stu2.getCourses().add( c1 );
        stu2.getCourses().add( c2 );

        //4.保存
        /**
         * 保存的注意事项
         * 1.配置级联保存,只保存学生对象
         *   插入2个学生，插入2两课程，中间4条，8条sql
         * 2.如果在Student配置inverse="true"，由Course来维护外键关系,中间表没数据
         * 3.默认Student配置inverse="false",由Student来维护外键关系,中间表有数据
         * 4.多对多，inverse不能两边都为true,如果两边都为true,不管保存哪个对象,中间表都没有数据
         */
		/*session.save(stu1);
		session.save(stu2);*/

        //课程拥有有学生
        c1.getStudents().add( stu1 );
        c1.getStudents().add( stu2 );

        c2.getStudents().add( stu1 );
        c2.getStudents().add( stu2 );

        session.save( c1 );
        session.save( c2 );

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2() {
        /**
         * 类级别的加载策略
         */
        Session session = HibernateUtils.openSession();
        //get方法即时加载数据,执行sql语句
        //load方法是懒加载数据，只有用到里面的数据时，才执行sql语句
        //load方法如果只是取id,也不会执行sql
        //如果在student.hbm.xml的class中配置lazy="false"，这时load方法就是即时加载
        Student stu1 = (Student) session.load( Student.class, 1 );

        System.out.println( "----------------" );

        System.out.println( stu1.getSid() );
        session.close();
    }

    @Test
    public void test3() {
        /**
         * 关联级别的加载策略
         * 1.默认情况Student下的course数据，只有访问的时候，才会执行SQL
         * 2.在set中配置lazy="false",不用访问course属性，也会先执行SQL查询数据
         */
        Session session = HibernateUtils.openSession();

        //查询学生
        Student stu1 = (Student) session.load( Student.class, 1 );

        System.out.println( stu1 );

        System.out.println( "---------------------" );
        //Student下的course也是懒加载,
		/*Set<Course> courses = stu1.getCourses();
		System.out.println(courses);*/

        session.close();
    }

    @Test
    public void test4() {
        /**
         * set集合中fetch讲解
         * select:【默认】,执行两条SQL语句
         * join:查询数据使用一条SQL语句搞定,使用左外连接
         * subselect:子查询，在条件里有select语句
         * 			 子查询只能用于多对多，一对多中
         */
        Session session = HibernateUtils.openSession();

        Query query = session.createQuery( "from Student" );

        List<Student> stus = query.list();
        for (Student stu : stus) {
            System.out.println( "学生名:" + stu.getName() );
            System.out.println( "学生选课程:" + stu.getCourses() );
        }
        session.close();
    }
}
