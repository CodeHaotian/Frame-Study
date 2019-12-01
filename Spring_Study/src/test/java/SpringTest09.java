import com.spring.study.domain.Gril;
import com.spring.study.service.GrilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 19:11
 * @Description: spring测试crud
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:gril.xml")
public class SpringTest09 {
    @Autowired
    private GrilService grilService;

    @Test
    public void add() {
        Gril gril = Gril.builder()
                .name( "阿尔托莉雅·潘德拉贡" )
                .age( 22 )
                .birthday( new Date() )
                .cup( "C" )
                .leg( "100" )
                .phone( "00000000004" )
                .address( "古不列颠王国" ).build();
        grilService.add( gril );
    }

    @Test
    public void update() {
        Gril gril = Gril.builder().id( 1 ).age( 20 ).build();
        grilService.update( gril );
    }

    @Test
    public void delete() {
        grilService.delete( 3 );

    }

    @Test
    public void findAll() {
        List<Gril> grilList = grilService.findAll();
        grilList.forEach( System.out::println );
    }

    @Test
    public void findById() {
        Gril gril = grilService.findByTd( 1 );
        System.out.println( gril );
    }
}
