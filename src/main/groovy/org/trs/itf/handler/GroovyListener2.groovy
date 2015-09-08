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





class GroovyListener2 extends Thread implements MessageListener{

	JAXBContext jaxbContext = JAXBContext.newInstance(QMessage.class);

	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	//static ServerSocket variable
	private static ServerSocket server;
	//socket server port on which it will listen
	private static int port = 8087;
	String outText=""
	final String host = "localhost";
	public void run() {

		System.out.println("Creating socket to '" + host + "' on port " + port);

		//create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
			outText=processMessage(message)
			println("outext "+outText)
            oos.writeObject(outText);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
			sleep(100);
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
		
		
		
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



