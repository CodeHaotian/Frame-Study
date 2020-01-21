package com.springamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Haotian
 * @Date: 2020/1/21 16:29
 * @Description: mq 进阶操作消息发送测试
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:advanced-spring-rabbitmq-producer.xml")
public class AdvancedProducerTest {

    //1.注入 RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 确认模式：
     * 步骤：
     * 1. 确认模式开启：ConnectionFactory中开启publisher-confirms="true"
     * 2. 在rabbitTemplate定义ConfirmCallBack回调函数
     */
    @Test
    public void testConfirm() {
        //2.定义回调
        rabbitTemplate.setConfirmCallback( new RabbitTemplate.ConfirmCallback() {
            /**
             * @param correlationData 相关配置信息
             * @param ack exchange交换机 是否成功收到了消息。true 成功，false代表失败
             * @param cause 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println( "confirm方法被执行了...." );
                if (ack) {
                    //接收成功
                    System.out.println( "接收消息成功" );
                } else {
                    System.out.println( "接收消息失败,错误详情：" + cause );
                    //做一些处理，让消息再次发送。
                }
            }
        } );
        //3. 发送消息
        rabbitTemplate.convertAndSend( "test_exchange_confirm", "confirm", "message confirm...." );
        rabbitTemplate.convertAndSend( "test_exchange_confirm", "confirm", "message confirm...." );
    }

    /**
     * 回退模式： 当消息发送给Exchange后，Exchange路由到Queue失败时，才会执行 ReturnCallBack
     * 步骤：
     * 1. 开启回退模式:publisher-returns="true"
     * 2. 设置ReturnCallBack
     * <pre>
     * 3. 设置Exchange处理消息的模式：
     *     1. 如果消息没有路由到Queue，则丢弃消息（默认）
     *     2. 如果消息没有路由到Queue，返回给消息发送方ReturnCallBack
     * </pre>
     */
    @Test
    public void testReturn() {
        //3.设置交换机处理失败消息的模式
        rabbitTemplate.setMandatory( true );

        //2.设置ReturnCallBack
        rabbitTemplate.setReturnCallback( new RabbitTemplate.ReturnCallback() {
            /**
             * @param message 消息对象
             * @param replyCode 错误码
             * @param replyText 错误信息
             * @param exchange  交换机
             * @param routingKey 路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println( "return 执行了...." );
                System.out.println( message );
                System.out.println( replyCode );
                System.out.println( replyText );
                System.out.println( exchange );
                System.out.println( routingKey );
                //回退处理
            }
        } );
        //3. 发送消息
        rabbitTemplate.convertAndSend( "test_exchange_confirm", "abc", "message confirm...." );
    }

    @Test
    public void testSend() {
        // 发送消息
        for (int i = 1; i <= 10; i++) {
            rabbitTemplate.convertAndSend( "test_exchange_confirm", "confirm", "第" + i + "条message confirm...." );
        }
    }
}