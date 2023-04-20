package com.activemq.controller;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
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
 * Servlet implementation class SendServlet
 */
@WebServlet(value ="/send", name = "send")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendServlet() {
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
		request.getRequestDispatcher("/WEB-INF/receive.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		String subject = request.getParameter("queue"); 
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        try {
        	 Connection connection = connectionFactory.createConnection();
             connection.start();
              
             Session session = connection.createSession(false,
                     Session.AUTO_ACKNOWLEDGE);  
       
             Destination destination = session.createQueue(subject); 
              
             MessageProducer producer = session.createProducer(destination);
              
             TextMessage message = session
                     .createTextMessage(request.getParameter("message"));
              
             producer.send(message);
              
             connection.close();
        } catch(Exception e) {
        	
        }
		doGet(request, response);
	}

}
