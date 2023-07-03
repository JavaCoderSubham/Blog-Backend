package com.blog.userInfo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfigaration  implements WebMvcConfigurer{

	
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/user")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("*");
	}
	
}
