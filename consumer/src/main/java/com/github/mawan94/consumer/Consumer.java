package com.github.mawan94.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage(String msg) {
        System.out.println(msg + " from topic");
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        System.out.println(msg + " from queue");
    }
}
