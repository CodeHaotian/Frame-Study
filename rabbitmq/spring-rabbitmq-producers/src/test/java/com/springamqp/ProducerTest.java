package com.springamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 19:52
 * @Description: Spring 整合 rabbitmq 消息发送端测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    //1.注入 RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送简单消息
     */
    @Test
    public void testHelloWorld() {
        //2.发送消息
        rabbitTemplate.convertAndSend( "spring_queue", "hello world spring...." );
    }

    /**
     * 发送fanout消息
     */
    @Test
    public void testFanout() {
        //2.发送消息
        rabbitTemplate.convertAndSend( "spring_fanout_exchange", "", "spring fanout...." );
    }

    /**
     * 发送topic消息
     */
    @Test
    public void testTopic() {
        //2.发送消息
        rabbitTemplate.convertAndSend( "spring_topic_exchange", "sakura.find.info", "spring topic...." );
    }
}