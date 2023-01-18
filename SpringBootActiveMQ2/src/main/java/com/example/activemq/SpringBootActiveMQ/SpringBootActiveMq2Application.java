package com.example.activemq.SpringBootActiveMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
This application has two approaches:
1) Listener approach: Consumer class acts as JMSListener component.
2) REST-API approach: ActiveMQController and ConsumerService.
*/
@SpringBootApplication
public class SpringBootActiveMq2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActiveMq2Application.class, args);
	}

}
