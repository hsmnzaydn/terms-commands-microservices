package com.hsmnzaydn.command_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommandServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandServicesApplication.class, args);
    }

}
