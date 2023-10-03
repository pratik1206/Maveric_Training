package com.maveric.api.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(value = 2)
@Component
public class ApplicationStartuoRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("This is run method from ApplicationStartuoRunner.........s ");
		
	}
  
}
