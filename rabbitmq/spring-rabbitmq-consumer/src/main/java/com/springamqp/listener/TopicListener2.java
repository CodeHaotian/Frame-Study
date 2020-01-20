package com.springamqp.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 20:27
 * @Description: topic模式监听队列二
 */
public class TopicListener2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        //打印消息
        System.out.println(new String(message.getBody()));
    }
}