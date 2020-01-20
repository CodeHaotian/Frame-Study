package com.springamqp.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Author: Haotian
 * @Date: 2020/1/20 20:27
 * @Description: fanout模式监听队列一
 */
public class FanoutListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        //打印消息
        System.out.println(new String(message.getBody()));
    }
}