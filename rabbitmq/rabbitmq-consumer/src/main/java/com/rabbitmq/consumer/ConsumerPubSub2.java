package com.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 16:46
 * @Description: mq订阅模式接收消息端
 */

public class ConsumerPubSub2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //2. 设置参数
        factory.setHost( "127.0.0.1" ); //ip  默认值 localhost
        factory.setPort( 5672 ); //端口  默认值 5672
        factory.setVirtualHost( "/study" ); //虚拟机 默认值/
        factory.setUsername( "zero" ); //用户名 默认 guest
        factory.setPassword( "zero" ); //密码 默认值 guest

        //3. 创建连接 Connection
        Connection connection = factory.newConnection();

        //4. 创建Channel
        Channel channel = connection.createChannel();

        //5. 接收消息
        DefaultConsumer consumer = new DefaultConsumer( channel ) {
            /*回调方法，当收到消息后，会自动执行该方法
                1. consumerTag：标识
                2. envelope：获取一些信息，交换机，路由key...
                3. properties:配置信息
                4. body：数据*/
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println( "body：" + new String( body ) );
                System.out.println( "将日志存入数据库" );
            }
        };
        /*basicConsume(String queue, boolean autoAck, Consumer callback)
        参数：
            1. queue：队列名称
            2. autoAck：是否自动确认
            3. callback：回调方法*/
        channel.basicConsume( "test_fanout_queue2", true, consumer );
    }

}