package com.hsmnzaydn.auth_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServicesApplication.class, args);
    }

}
