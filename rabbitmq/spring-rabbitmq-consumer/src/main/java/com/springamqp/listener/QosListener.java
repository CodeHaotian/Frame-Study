package com.springamqp.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Haotian
 * @Date: 2020/1/21 17:51
 * @Description: <pre>Consumer 限流机制：
 *                          1. 确保ack机制为手动确认。
 *                          2. listener-container配置属性
 *                              prefetch = 2,表示消费端每次从mq拉取两条消息来消费，直到手动确认消费完毕后，才会继续拉取下一条消息。</pre>
 */
@Component
public class QosListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep( 2000 );
        //1.获取消息
        System.out.println( new String( message.getBody() ) );
        //2. 处理业务逻辑
        //3. 签收
        channel.basicAck( message.getMessageProperties().getDeliveryTag(), true );
    }
}