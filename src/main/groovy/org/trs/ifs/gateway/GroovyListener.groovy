package org.trs.ifs.gateway



import javax.jms.Connection
import javax.jms.DeliveryMode
import javax.jms.Destination
import javax.jms.JMSException
import javax.jms.Message
import javax.jms.MessageConsumer
import javax.jms.MessageListener
import javax.jms.MessageProducer
import javax.jms.Session
import javax.jms.TextMessage
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller

import org.apache.activemq.ActiveMQConnectionFactory
import org.trs.ifs.itf.QMessage;





class GroovyListener extends Thread implements MessageListener{

	JAXBContext jaxbContext = JAXBContext.newInstance(QMessage.class);

	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

	String outText=""
	public void run() {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("MAIN.2");
		MessageConsumer consumer = session.createConsumer(destination);

		ActiveMQConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection1 = connectionFactory1.createConnection();
		connection1.start();
		Session session1 = connection1.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination1 = session1.createQueue("MAIN.3");
		MessageProducer replyProducer = session1.createProducer(null);
		replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);



		println 'all set'
		while(true){
			TextMessage response =null

			try {
				println 'idle'
				Message message = consumer.receive(500);
				
				if(message instanceof TextMessage && ((TextMessage)message).getText()!=null) {
					TextMessage txtMsg = (TextMessage) message;
					String inMessageText = txtMsg.getText();
					println("Received: " + inMessageText);
					outText=processMessage(inMessageText)
					println("outext "+outText)
					response = session1.createTextMessage(outText);
					replyProducer.send(destination1, response);

					//				replyProducer.close()
					//				session.close();
					//				connection.close();

				}


			}catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
				response.setText("ERROR");

				continue;
			}finally{
				try
				{

				}
				catch (Throwable e)
				{
					// Swallow
				}
			}

			sleep(100);
		}


	}

	public String processMessage(String inMessageText){
		String topic =""
		QMessage domainMessage
		try {
			StringReader reader = new StringReader(inMessageText)
			domainMessage= (QMessage) jaxbUnmarshaller.unmarshal(reader);
			topic = domainMessage.getHandler()


		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}

		return TopicDispatcher.handle(topic, domainMessage.getFileName(), domainMessage.getMeta())

	}
	public void onMessage(Message message) {}
	public synchronized void onException(JMSException ex) {
		System.out.println("JMS Exception occured.  Shutting down client.");
	}
}



