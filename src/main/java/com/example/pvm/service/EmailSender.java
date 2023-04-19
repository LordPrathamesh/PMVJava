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

import com.example.pvm.utils.Utils;

@Service
public class EmailSender {
	
	@Autowired
	@Qualifier("session")
	private Session session;
	
	@Autowired
	private Utils utils;
	
	@Value("${gmail-id}")
	private String username;
	
	@Value("${gmail-pass}")
	private String password;
	
	public Map<String, String> sendEmail(String recipients) {
		// Set properties for the email connection
		int OTP= utils.generateOTP();
		String htmlBody = "<html><body><p>Dear User,</p>"
                + "<p>Your One-Time Password (OTP) for login verification is:</p>"
                + "<h2>"+OTP+"</h2>"
                + "<p>Please enter this OTP on the login screen to complete the verification process. This OTP is valid for the next 5 minutes only.</p>"
                + "<p>If you did not request this OTP, please contact our support team immediately.</p>"
                + "<p>Thank you,</p>"
                + "<p>ParkMyVehicle Support Team</p>"
                + "</body></html>";

		try {
			// Create a new message
			Message message = new MimeMessage(session);

			// Set the sender and recipient addresses
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));

			// Set the subject and content of the email
			message.setSubject(" One-Time Password (OTP) for Email Verification");
//			message.set setText("OTP : "+OTP);
			message.setContent(htmlBody, "text/html");

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
