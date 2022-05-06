package com.tasks.mailservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	final Logger LOG = LoggerFactory.getLogger(MailService.class);
	
	public void sendMail(String email) {

			System.out.println("ENETERD MAIL SERVICE ... .?/////////////////////");
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setFrom("sanjeevana2345@gmail.com");
			mail.setBcc("sanjeevana234@gmail.com");
			mail.setCc("sravantir@techmologics.com");
			String body = "Hi Techmo..!This is Ravi SanjeeOne";
			mail.setText(body);
			mail.setSubject("BOOT tASK CHECKING...");
			mail.setTo(email);
			LOG.info("MAIL SENDING IS STARTED..");
			mailSender.send(mail);
			LOG.info("MAIL SENT SUCCESSFULLY..");
		
		
		
	}
	

}
