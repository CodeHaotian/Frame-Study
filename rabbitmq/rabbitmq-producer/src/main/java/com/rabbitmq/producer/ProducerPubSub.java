package com.rabbitmq.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 16:46
 * @Description: mq订阅模式发送消息端
 */
public class ProducerPubSub {
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

        //5. 创建交换机
        /*exchangeDeclare(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
       参数：
        1. exchange:交换机名称
        2. type:交换机类型
            DIRECT("direct"),：定向
            FANOUT("fanout"),：扇形（广播），发送消息到每一个与之绑定队列。
            TOPIC("topic"),通配符的方式
            HEADERS("headers");参数匹配
        3. durable:是否持久化
        4. autoDelete:自动删除
        5. internal：内部使用。 一般false
        6. arguments：参数*/
        String exchangeName = "test_fanout";
        channel.exchangeDeclare( exchangeName, BuiltinExchangeType.FANOUT, true, false, false, null );

        //6. 创建队列
        channel.queueDeclare( "test_fanout_queue1", true, false, false, null );
        channel.queueDeclare( "test_fanout_queue2", true, false, false, null );

        //7. 绑定队列和交换机
        /*queueBind(String queue, String exchange, String routingKey)
        参数：
            1. queue：队列名称
            2. exchange：交换机名称
            3. routingKey：路由键，绑定规则
                如果交换机的类型为fanout ，routingKey设置为""*/
        channel.queueBind( "test_fanout_queue1", exchangeName, "" );
        channel.queueBind( "test_fanout_queue2", exchangeName, "" );

        //8. 发送消息
        channel.basicPublish( exchangeName, "", null, "日志信息：admin调用了findAll方法...日志级别：info...".getBytes() );

        //9.释放资源
        channel.close();
        connection.close();
    }

}