package com.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class BlogDetailsConfiguration {

    @Bean
    public WebClient webClient() {
        log.info("webClient() -> | Object Created...");
        return WebClient.builder().build();
    }

}
