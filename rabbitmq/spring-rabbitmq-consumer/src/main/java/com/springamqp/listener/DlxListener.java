package com.springamqp.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Haotian
 * @Date: 2020/1/22 13:11
 * @Description: 拒绝签收消息，让消息进入死信
 **/
@Component
public class DlxListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //1.接收转换消息
        System.out.println( new String( message.getBody() ) );
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //2. 处理业务逻辑
            System.out.println( "处理业务逻辑..." );
            int i = 3 / 0;//模拟异常
            //3. 正常手动签收
            channel.basicAck( deliveryTag, true );
        } catch (Exception e) {
            System.out.println( "业务异常，拒绝签收消息，放入死信交换机" );
            //4.异常拒绝签收，不重回队列 requeue=false才能进入死信
            channel.basicNack( deliveryTag, true, false );
        }
    }
}