package com.ridesharing.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    private static final Logger log = LoggerFactory.getLogger(ApiGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter loggingFilter() {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();
            log.info("[API-GATEWAY] Routing request: {} {}", exchange.getRequest().getMethod(), path);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("[API-GATEWAY] Completed request for {} with status {}", path, exchange.getResponse().getStatusCode());
            }));
        };
    }
}
