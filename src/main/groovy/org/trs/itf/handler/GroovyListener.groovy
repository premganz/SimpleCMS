package org.trs.itf.handler



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
import org.trs.itf.model.QMessage





class GroovyListener extends Thread implements MessageListener{
	
	JAXBContext jaxbContext = JAXBContext.newInstance(QMessage.class);
	
	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

	String outText=""
	public void run() {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		// Create a Connection
		
		println 'all set'
		while(true){
			TextMessage response =null
			
			try {
			
				println 'idle'
				Connection connection = connectionFactory.createConnection();
				// Wait for a message
				
				connection.start();
		
				//connection.setExceptionListener(this);
		
				// Create a Session
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
				// Create the destination (Topic or Queue)
				Destination destination = session.createQueue("MAIN.2");
		
				// Create a MessageConsumer from the Session to the Topic or Queue
				MessageConsumer consumer = session.createConsumer(destination);				
				MessageProducer replyProducer = session.createProducer(null);
				Message message = consumer.receive(500);				
				response = session.createTextMessage();
				if(message!=null){
					TextMessage txtMsg = (TextMessage) message;
					String inMessageText = txtMsg.getText();
					println("Received: " + inMessageText);
					//sleep(500)					
					outText=processMessage(inMessageText)
				
					response.setText(outText);
					response.setJMSCorrelationID(message.getJMSCorrelationID());
	
					replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
					replyProducer.send(message.getJMSReplyTo(), response);
					println("outext "+outText)
					
					
				consumer.close();
				replyProducer.close()
                session.close();
                connection.close();
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
					}
					
					return TopicDispatcher.handle(topic, domainMessage.getFileName(), domainMessage.getMeta())
				 
	}
	public void onMessage(Message message) {}
	public synchronized void onException(JMSException ex) {
		System.out.println("JMS Exception occured.  Shutting down client.");
	}
}



