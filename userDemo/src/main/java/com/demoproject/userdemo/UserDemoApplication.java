package com.demoproject.userdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demoproject.userdemo")
public class UserDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserDemoApplication.class, args);
	}

}
