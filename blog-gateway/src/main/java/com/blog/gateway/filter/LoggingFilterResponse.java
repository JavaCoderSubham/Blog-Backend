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
public class LoggingFilterResponse implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | ServerWebExchange : {} | GatewayFilterChain : {}"
                ,exchange,chain);

        if(exchange.getResponse().getStatusCode().isError()) {
            log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Response Error : {}"
                    ,exchange.getResponse().getStatusCode().value());
        }

        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Response Headers : {}"
                ,exchange.getResponse().getHeaders());
        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Response Cookies : {}"
                ,exchange.getResponse().getCookies());
        log.info("filter(ServerWebExchange,GatewayFilterChain) -> | Response Status Code : {}"
                ,exchange.getResponse().getStatusCode());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}




