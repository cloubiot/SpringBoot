package com.springboot.queue.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.springboot.clib.service.EmailService;
import com.springboot.model.email.EmailMessage;


@Component
public class EmailQSubscriber {
	
	@Autowired
	private EmailService emailService;
	

//	@JmsListener(destination = "email.queue5")
//	public void receiveQueue(EmailMessage emailMsg) throws Exception {
//		System.out.println("Subscribed queue msg"+emailMsg);
//		emailService.sendEmail(emailMsg.getToEmail(), emailMsg.getSubject(), emailMsg.getEmailBody());
//		
//	}

}

