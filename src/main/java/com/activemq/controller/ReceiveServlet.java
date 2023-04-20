package com.activemq.controller;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Servlet implementation class ReceiveServlet
 */
@WebServlet(value = "/receive", name = "receive")
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			 String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
			 String subject = request.getParameter("queue");
			 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			 Connection connection = connectionFactory.createConnection();
			 connection.start();
	 
			 Session session = connection.createSession(false,
	                Session.AUTO_ACKNOWLEDGE);
	 
			 Destination destination = session.createQueue(subject);
	 
			 MessageConsumer consumer = session.createConsumer(destination);
	 
			 Message message = consumer.receive();
	 
	        if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            request.setAttribute("message", textMessage.getText());
	        }
	        connection.close();
		}catch(Exception e) {
			
		}
		doGet(request, response);
	}

}
