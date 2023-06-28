package com.blog.subscribe.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendSimpleEmail(String toEmail, String body, String subject) {
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setFrom("jrrchowdary9821@gmail.com");
//		mailMessage.setTo(toEmail);
//		mailMessage.setText(body);
//		mailMessage.setSubject(subject);
//		
//		javaMailSender.send(mailMessage);
		
		MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.setFrom(new InternetAddress("jrrchowdary9821@gmail.com", "Rajaram Jasthi"));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);
        } catch (Exception e) {
        	throw new RuntimeException("Unable to send the registration mail to the user");
        }
	}
}