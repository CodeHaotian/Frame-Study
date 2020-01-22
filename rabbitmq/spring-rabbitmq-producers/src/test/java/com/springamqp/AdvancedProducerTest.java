package com.springamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
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

    /* TTL:过期时间
     *  1. 队列统一过期
     *  2. 消息单独过期
     * 如果设置了消息的过期时间，也设置了队列的过期时间，它以时间短的为准。
     * 队列过期后，会将队列所有消息全部移除。
     * 消息过期后，只有消息在队列顶端，才会判断其是否过期(移除掉)
     */
    @Test
    public void testTtl() {
        // 消息后处理对象，设置一些消息的参数信息
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //1.设置message的信息
                message.getMessageProperties().setExpiration( "5000" );//消息的过期时间
                //2.返回该消息
                return message;
            }
        };
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                //消息单独过期
                rabbitTemplate.convertAndSend( "test_exchange_ttl", "ttl.message", "第" + i + "条message ttl....", messagePostProcessor );
            } else {
                //不过期的消息
                rabbitTemplate.convertAndSend( "test_exchange_ttl", "ttl.message", "第" + i + "条message ttl...." );

            }
        }
    }

    /**
     * 发送测试死信消息：
     * 1. 过期时间(原队列存在消息过期时间，消息到达过期时间未被消费)
     * 2. 长度限制(队列长度到达设置的上限，多余的消息进入死信)
     * 3. 消息拒收(消费者拒收消费消息，并且不重回对列)
     */
    @Test
    public void testDlx() {
        //1. 测试过期时间
        //rabbitTemplate.convertAndSend( "test_exchange_dlx", "test.dlx.message", "我是一条消息，存活时间到达进入死信" );
        //2. 测试长度限制
        /*for (int i = 1; i <= 20; i++) {
            rabbitTemplate.convertAndSend( "test_exchange_dlx", "test.dlx.message", "我是第" + i + "条消息，超过10条后续进入死信" );
        }*/
        //3. 测试消息拒收
        rabbitTemplate.convertAndSend( "test_exchange_dlx", "test.dlx.message", "我是一条消息，被拒绝签收后进入死信" );
    }

    /**
     * 延迟队列：ttl + dlx 组合实现延迟
     */
    @Test
    public void testDelay() {
        // 模拟下订单息。 半个小时候后发送
        rabbitTemplate.convertAndSend( "order_exchange", "order.msg", "订单信息：id=1,time=2020年1月22日16:31:38" );
    }
}