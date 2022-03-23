package com.retrocicla.felipeazs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.retrocicla.felipeazs.security.AppProperties;


@SpringBootApplication
public class RetrociclaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrociclaAppApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	
	@Bean
	public AppProperties getAppProperties() {
		return new AppProperties();
	}

}
