package springamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 19:52
 * @Description: mq 进阶特性消息接收端测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:advanced-spring-rabbitmq-producer.xml")
public class AdvancedConsumerTest {
    @Test
    public void test() {
        while (true) {

        }
    }
}