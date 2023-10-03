package com.maveric.projectrest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootConfiguration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class PracticeApiApplication { 

	public static void main(String[] args) {
		SpringApplication.run(PracticeApiApplication.class, args);
		
	}

}
