package com.joker.security.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class JokerResourceServer extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JokerResourceServer.class, args);

	}

}
