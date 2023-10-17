package com.loan.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.loan.services.iMailService;

@Service
@Primary
public class MailServiceImpl implements iMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("%{spring.mail.username}")
	private String senderEmail;

	private Logger logger = Logger.getLogger(getClass());

	public void sendMail(String recipientEmail) {
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(recipientEmail);
			mail.setFrom(senderEmail);
			mail.setSubject("Loan Management Company");
			mail.setText("Hello,\n \n Thanks for contacting us. Someone from our team will get back to you soon. \n\n Regards, \n Loan Management Company \n");
			javaMailSender.send(mail);
			logger.info("Mail Sent Successfully to: " + recipientEmail + " from: " + senderEmail);
		} catch (Exception e) {
			throw new com.loan.exceptions.MailException("Failed to deliver mail");
		}
	}

}
