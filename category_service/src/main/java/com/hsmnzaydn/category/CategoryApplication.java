package com.hsmnzaydn.category;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@SpringBootApplication(scanBasePackages = "com.hsmnzaydn")
@RestController
public class CategoryApplication {

	@Value("${eureka.client.service-url.default-zone}")
	private String myValues;

	public static void main(String[] args) {

		SpringApplication.run(CategoryApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String name() {
		return myValues;
	}
}
