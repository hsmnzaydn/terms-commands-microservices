package com.hsmnzaydn.command_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.hsmnzaydn.core_entity_lib")
public class CommandServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandServicesApplication.class, args);
    }

}
