package com.demoMicro.ratinginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demoMicro.ratinginfo")
public class RatingInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingInfoApplication.class, args);
	}

}
