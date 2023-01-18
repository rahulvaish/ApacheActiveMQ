package com.example.activemq.SpringBootActiveMQ;

import javax.jms.*;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@Autowired
	JmsTemplate jmsTemplate;

	public void getEmail() throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin",
				"tcp://localhost:61616");

		try {
			Connection connection = factory.createConnection();
			connection.setClientID("1");
			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Topic topic = session.createTopic("demo-topic");

			MessageConsumer consumer = session.createDurableSubscriber(topic, "Consumer-1");
			consumer.setMessageListener(new MessageListener() {

				public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}


