package com.github.mawan94.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;


    public void sendMsg() {
        for (int i = 0; i < 10; i++) {
            jmsMessagingTemplate.convertAndSend(queue, "queue,world!" + i);
            jmsMessagingTemplate.convertAndSend(topic, "topic,world!" + i);
        }
    }
}
