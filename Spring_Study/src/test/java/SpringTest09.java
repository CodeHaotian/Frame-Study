import com.spring.study.domain.Girl;
import com.spring.study.service.GirlService;
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
@ContextConfiguration("classpath:girl.xml")
public class SpringTest09 {
    @Autowired
    private GirlService girlService;

    @Test
    public void add() {
        Girl girl = Girl.builder()
                .name( "阿尔托莉雅·潘德拉贡" )
                .age( 22 )
                .birthday( new Date() )
                .cup( "C" )
                .leg( "100" )
                .phone( "00000000004" )
                .address( "古不列颠王国" ).build();
        girlService.add( girl );
    }

    @Test
    public void update() {
        Girl girl = Girl.builder().id( 1 ).age( 20 ).build();
        girlService.update( girl );
    }

    @Test
    public void delete() {
        girlService.delete( 3 );

    }

    @Test
    public void findAll() {
        List<Girl> girlList = girlService.findAll();
        girlList.forEach( System.out::println );
    }

    @Test
    public void findById() {
        Girl girl = girlService.findByTd( 1 );
        System.out.println( girl );
    }
}
