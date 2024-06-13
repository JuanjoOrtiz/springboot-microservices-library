package com.project.microservice.gateway.beans;

import com.project.microservice.gateway.filter.AuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Set;

@Configuration
@AllArgsConstructor
public class GatewayBeans {

    private final AuthFilter authFilter;

    @Bean
    @Profile(value = "eureka-off")
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder builder){
        return  builder
                .routes()
                .route(route -> route
                        .path("/books/*")
                        .uri("http://localhost:8081")
                )
                .route(route -> route
                        .path("/loans/*")
                        .uri("http://localhost:8083")

                )
                .route(route -> route
                        .path("/members/*")
                        .uri("http://localhost:8085")

                )
                .build();
    }

    @Bean
    @Profile(value = "eureka-on")
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder builder){
        return  builder
                .routes()
                .route(route -> route
                        .path("/books/*")
                        .uri("http://localhost:8081")
                )
                .route(route -> route
                        .path("/loans/*")
                        .uri("http://localhost:8083")

                )
                .route(route -> route
                        .path("/members/*")
                        .uri("http://localhost:8085")

                )
                .build();
    }

    @Bean
    @Profile(value = "eureka-on-cb")
    public RouteLocator routeLocatorEurekaOnCB(RouteLocatorBuilder builder){
        return  builder
                .routes()
                .route(route -> route
                        .path("/books/**")
                        .filters(filter ->{
                            filter.circuitBreaker(config -> config
                                    .setName("gateway-cb")
                                    .setStatusCodes(Set.of("500", "400"))
                                    .setFallbackUri("forward:/books-fallback/*"));
                            return filter;
                        })
                        .uri("lb://books")
                )
                .route(route -> route
                        .path("/books-fallback/**")
                        .uri("lb://books-fallback")
                )
                .route(route -> route
                        .path("/loans/**")
                        .filters(filter ->{
                            filter.circuitBreaker(config -> config
                                    .setName("gateway-cb")
                                    .setStatusCodes(Set.of("500", "400"))
                                    .setFallbackUri("forward:/loans-fallback/*"));
                            return filter;
                        })
                        .uri("lb://loans")
                )
                .route(route -> route
                        .path("/loans-fallback/**")
                        .uri("lb://loans-fallback")
                )
                .route(route -> route
                        .path("/members/**")
                        .filters(filter ->{
                            filter.circuitBreaker(config -> config
                                    .setName("gateway-cb")
                                    .setStatusCodes(Set.of("500", "400"))
                                    .setFallbackUri("forward:/members-fallback/*"));
                            return filter;
                        })
                        .uri("lb://members")
                )
                .route(route -> route
                        .path("/members-fallback/**")
                        .uri("lb://members-fallback")
                )

                .build();
    }


}
