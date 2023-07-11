package com.blog.subscribe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SubscribeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscribeMicroserviceApplication.class, args);
	}

}
