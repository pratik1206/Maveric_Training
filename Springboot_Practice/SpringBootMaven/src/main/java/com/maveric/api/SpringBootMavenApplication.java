package com.maveric.api;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class SpringBootMavenApplication {
	
//	protected final Log logger = LogFactory.getLog(getClass());
		
	
	
	public static void main(String[] args) {
//		System.out.println("Main is Executed..........");
	SpringApplication.run(SpringBootMavenApplication.class, args);
	}
//	@Override
//	public void run(String... args) throws Exception {
////		System.out.println("This is run method from Commandline.........s ");
//		logger.error("This is a error message");
//		logger.info("This is info");
//		logger.warn("This is warning");
//		logger.debug("This is debug");
//		
//	}
}


