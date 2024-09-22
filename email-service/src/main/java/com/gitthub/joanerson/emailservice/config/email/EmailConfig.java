package com.gitthub.joanerson.emailservice.config.email;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

@Configurable
public class EmailConfig {
	
	@Value("${mail.host}")
	private String host;
	@Value("${mail.port}")
	private String port;
	@Value("${mail.username}")
	private String username;
	@Value("${mail.password}")
	private String password;
	@Value("${mail.protocol}")
	private String protocol;
	
//	public JavaMailSenderImpl mailSender() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		return mailSender;
//	}
}
