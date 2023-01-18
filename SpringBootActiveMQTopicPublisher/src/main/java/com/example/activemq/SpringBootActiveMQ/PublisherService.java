package com.example.activemq.SpringBootActiveMQ;

import javax.jms.*;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

	@Autowired
	JmsTemplate jmsTemplate;

	public String sendEmail(Email email) throws Exception {

		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin",
				"tcp://localhost:61616");

		JSONObject emailJsonObject = new JSONObject();
		emailJsonObject.put("emailAddress", email.getEmailIdAddress());
		emailJsonObject.put("subject", email.getSubject());
		emailJsonObject.put("body", email.getBody());

		try {
			Connection connection = factory.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createTopic("demo-topic");

			MessageProducer producer = session.createProducer(destination);

			TextMessage textMessage = session.createTextMessage(emailJsonObject.toString());;

			producer.send(textMessage);

			System.out.println("Message published to topic");

			session.close();
			connection.close();
			return "Message published to topic";
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return "Messaged Failed to publish";
	}

}
