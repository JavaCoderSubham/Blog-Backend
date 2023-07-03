package com.blog.userInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@SpringBootApplication
public class UserinfoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserinfoMicroserviceApplication.class, args);
	}

}
