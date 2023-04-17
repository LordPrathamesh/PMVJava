package com.example.pvm.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	
	@Autowired
	@Qualifier("session")
	private Session session;
	
	@Value("${gmail-id}")
	private String username;
	
	@Value("${gmail-pass}")
	private String password;
	
	public Map<String, String> sendEmail(String recipients) {
		// Set properties for the email connection
		

		try {
			// Create a new message
			Message message = new MimeMessage(session);

			// Set the sender and recipient addresses
			message.setFrom(new InternetAddress("your-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));

			// Set the subject and content of the email
			message.setSubject("Test Email");
			message.setText("This is a test email sent from Java.");

			// Send the email
			Transport.send(message);

			System.out.println("Email sent successfully!");
			Map<String, String> resp = new HashMap<String, String>();
			resp.put("status", "Success");
			return resp;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
