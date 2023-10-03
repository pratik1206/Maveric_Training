package com.maveric.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DepartmentServiceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceEurekaApplication.class, args);
	}
	@GetMapping("/")
	public String getDepartmentServer() {
		return "Department Service is called";
	}
	@GetMapping("/hello")
	public String getMessage() {
		return "getting message from server";
	}
	
}
