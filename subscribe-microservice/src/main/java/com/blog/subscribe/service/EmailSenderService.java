package com.blog.subscribe.service;

public interface EmailSenderService {
	void sendSimpleEmail(String toEmail, String body, String subject);
}
