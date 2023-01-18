package com.example.activemq.SpringBootActiveMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "demo-topic")
    public void receiveMessage(String emailObject){
        System.out.println(emailObject);
    }

}
