package com.kuka.Wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class WishlistApplication {

    public static void main(String[] args) {

        SpringApplication.run(WishlistApplication.class, args);
    }


}

