package com.hsmzaydn.category_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.hsmnzaydn.core_entity_lib")
public class CategoryServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryServicesApplication.class, args);
    }

}
