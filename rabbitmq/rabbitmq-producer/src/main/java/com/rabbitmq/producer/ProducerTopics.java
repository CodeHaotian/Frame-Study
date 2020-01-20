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
 * @Description: mq通配符模式发送消息端, #匹配多个单词，*匹配一个单词
 */
public class ProducerTopics {
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
        String exchangeName = "test_topic";
        channel.exchangeDeclare( exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null );

        //6. 创建队列
        channel.queueDeclare( "test_topic_queue1", true, false, false, null );
        channel.queueDeclare( "test_topic_queue2", true, false, false, null );

        //7. 绑定队列和交换机
        /*queueBind(String queue, String exchange, String routingKey)
        参数：
            1. queue：队列名称
            2. exchange：交换机名称
            3. routingKey：路由键，绑定规则
                如果交换机的类型为fanout ，routingKey设置为""*/
        //队列一需求：所有error级别的日志存入数据库，所有order系统的日志存入数据库
        channel.queueBind( "test_topic_queue1", exchangeName, "#.error" );
        channel.queueBind( "test_topic_queue1", exchangeName, "order.*" );
        //队列2将所有信息打印到控制台
        channel.queueBind( "test_topic_queue2", exchangeName, "#.#" );

        //8. 发送消息
        channel.basicPublish( exchangeName, "order.error", null, "日志信息：未知用户...出错误了。。。日志级别：error...".getBytes() );
        channel.basicPublish( exchangeName, "user.findAll.error", null, "日志信息：未知用户调用findAll...出错误了。。。日志级别：error...".getBytes() );
        channel.basicPublish( exchangeName, "user.login.info", null, "日志信息：admin进行登录。。。日志级别：info...".getBytes() );

        //9.释放资源
        channel.close();
        connection.close();
    }

}