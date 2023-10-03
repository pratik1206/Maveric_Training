package com.kuka;

import com.kuka.service.IUserService;
import com.kuka.dtos.AddUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        IUserService service = context.getBean(IUserService.class);
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        System.out.println("encoded password" + passwordEncoder);
        Environment environment = context.getBean(Environment.class);
        String username = environment.getProperty("admin.username");
        String password = environment.getProperty("admin.password");
        System.out.println("username" + username);
        System.out.println("password" + password);
        System.out.println("username" + username);
        String email = environment.getProperty("admin.email");
        AddUser request = new AddUser();
        request.setUsername(username);
        request.setPassword(password);
        request.setEmail(email);
        service.registerAdmin(request);
    }

    @Bean
    public ApplicationContext applicationContext() {
        return new AnnotationConfigApplicationContext();
    }
}