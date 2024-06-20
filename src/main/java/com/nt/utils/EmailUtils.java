package com.nt.utils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {	
	@Autowired
	private JavaMailSender sender;	
	public  boolean sendEmail(String subject,String body, String to,File fo) {
		try {
			//method to create mimeMessage
			MimeMessage mimMessage = sender.createMimeMessage();
			     MimeMessageHelper helper = new MimeMessageHelper(mimMessage, true);			     
			     helper.setSubject(subject);
			     helper.setText(body, true);
			     helper.setTo(to);
			     helper.addAttachment("Plans_Info", fo);
			     sender.send(mimMessage);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return true;
	}	
}
