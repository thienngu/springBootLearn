package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class LoginApiSpringBootApplication {

	public static void main(String[] args) {
		javaMailSender.send(msg);
		SpringApplication.run(LoginApiSpringBootApplication.class, args);
		
	}

}
