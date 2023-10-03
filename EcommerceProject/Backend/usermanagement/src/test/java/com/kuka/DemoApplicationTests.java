package com.kuka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		//return  NoOpPasswordEncoder.getInstance();// use in operation/production
		return new BCryptPasswordEncoder();


	}
}
