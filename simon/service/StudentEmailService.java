package com.simon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service 
public class StudentEmailService {
   @Autowired
	private JavaMailSender mailSender;
   
   public void sendEmail(String subject, String body,String to)
   {
	   try {
		   SimpleMailMessage smail =  new SimpleMailMessage();
		   smail.setSubject(subject);
		   smail.setText(body);
		   smail.setTo(to);
		   mailSender.send(smail);
	   }
	   catch(Exception e) {
		   System.out.println("yeno yeno agide");
		   e.printStackTrace();
	   }
	   
   }
   
   public void sendMail2(String subject,String body,String to) {
	   try {
		   MimeMessage mimeMessage = mailSender.createMimeMessage();
		   MimeMessageHelper helper =  new MimeMessageHelper(mimeMessage);
		   helper.setSubject(subject);
		   helper.setText(body,true);
		   helper.setTo(to);
		   mailSender.send(mimeMessage);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
		   
   }
   
   
}
