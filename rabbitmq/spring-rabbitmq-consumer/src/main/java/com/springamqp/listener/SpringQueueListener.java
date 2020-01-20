package com.springamqp.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 20:25
 * @Description: 普通模式监听类
 */
public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        //打印消息
        System.out.println( new String( message.getBody() ) );
    }
}