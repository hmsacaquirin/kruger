package com.example.serviceinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
@SpringBootApplication
public class ServiceInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInventoryApplication.class, args);
    }

}
