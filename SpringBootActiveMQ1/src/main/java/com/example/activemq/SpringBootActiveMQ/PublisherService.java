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

		JSONObject emailJsonObject = new JSONObject();
		emailJsonObject.put("emailAddress", email.getEmailIdAddress());
		emailJsonObject.put("subject", email.getSubject());
		emailJsonObject.put("body", email.getBody());

		jmsTemplate.send("demo", session -> {
			ObjectMessage object = session.createObjectMessage(emailJsonObject.toString());
			return object;
		});
		return "Message Published";



//		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin",
//				"tcp://localhost:61616");
//		Connection connection = null;
//		Session session = null;
//		try {
//			connection = factory.createConnection();
//			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			Destination destination = session.createQueue("demo");
//			MessageProducer producer = session.createProducer(destination);
//
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("emailAddress", email.getEmailIdAddress());
//			jsonObject.put("subject", email.getSubject());
//			jsonObject.put("body", email.getBody());
//
//			TextMessage emailObjAsString = session.createTextMessage(jsonObject.toString());
//			producer.send(emailObjAsString);
//			return "Message Published";
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//			connection.close();
//		}
//		return "Message Failed to publish";
	}

}
