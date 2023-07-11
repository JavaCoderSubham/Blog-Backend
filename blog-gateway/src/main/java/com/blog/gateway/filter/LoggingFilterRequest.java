package com.blog.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilterRequest implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | ServerWebExchange : {} | GatewayFilterChain : {}"
                ,exchange,chain);
        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Request Method : {}"
                ,exchange.getRequest().getMethod());
        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Request URI : {}"
                ,exchange.getRequest().getURI());
        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Request Headers : {}"
                ,exchange.getRequest().getHeaders());

//        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Request Body : {}"
//                ,exchange.getRequest().getBody());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
