package com.blog.gateway.config;

import com.blog.gateway.filter.LoggingFilterRequest;
import com.blog.gateway.filter.LoggingFilterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class GatewayConfiguration {

    private final LoggingFilterRequest loggingFilterRequest;

    private final LoggingFilterResponse loggingFilterResponse;

    public GatewayConfiguration(LoggingFilterRequest loggingFilterRequest, LoggingFilterResponse loggingFilterResponse) {
        this.loggingFilterRequest = loggingFilterRequest;
        this.loggingFilterResponse = loggingFilterResponse;
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//        ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
        log.info("routeLocator(RouteLocatorBuilder) -> | RouteLocatorBuilder : {} | WebRequest : {}"
                ,builder);

        return builder.routes()
//                ============= BLOG MICROSERVICE ROUTE =============
                .route("BLOG-MICROSERVICE", r->r.path("/blog/**")
                        .filters(f->f.filter(this.loggingFilterRequest).filter(this.loggingFilterResponse))
                        .uri("lb://BLOG-SERVICE"))

//                ============= USER MICROSERVICE ROUTE =============
                .route("USER-MICROSERVICE",r-> r.path("/user/**")
                        .filters(f->f.filter(this.loggingFilterRequest).filter(this.loggingFilterResponse))
                        .uri("lb://USER-SERVICE"))

//                ============= OWNER MICROSERVICE ROUTE =============
                .route("OWNER-MICROSERVICE", r->r.path("/superAdmin/**")
                        .filters(f->f.filter(this.loggingFilterRequest).filter(this.loggingFilterResponse))
                        .uri("lb://OWNER-SERVICE")
                )

////                ============= AUTHORIZATION MICROSERVICE ROUTE =============
////                TODO Security Not Confirm
//                .route("AUTHORIZATION-MICROSERVICE", r->r.path("/auth/**")
//                        .filters(f->f.filter(this.loggingFilterRequest).filter(this.loggingFilterResponse))
//                        .uri("lb://AUTHORIZATION-SERVICE")
//                )


//                ============= SUBSCRIBE MICROSERVICE ROUTE =============
                .route("SUBSCRIBE-MICROSERVICE", r->r.path("/subscribe/**")
                        .filters(f->f.filter(this.loggingFilterRequest).filter(this.loggingFilterResponse))
                        .uri("lb://SUBSCRIBE-SERVICE")
                )

                .build();
    }

}
