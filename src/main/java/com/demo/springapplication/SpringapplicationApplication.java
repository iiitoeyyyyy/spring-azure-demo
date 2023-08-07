package com.demo.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringapplicationApplication.class, args);
	}

}
