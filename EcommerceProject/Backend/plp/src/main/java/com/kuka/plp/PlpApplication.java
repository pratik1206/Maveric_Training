package com.kuka.plp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication

public class PlpApplication {
	/**
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(PlpApplication.class, args);
	}

}
