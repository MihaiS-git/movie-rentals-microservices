package ubb.movierentals.Gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rentalentity", r -> r.path("/api/rentals/**").uri("http://rentalentity:9095/api/rentals"))
                .route("cliententity", r -> r.path("/api/clients/**").uri("http://cliententity:9096/api/clients"))
                .route("movieentity", r -> r.path("/api/movies/**").uri("http://movieentity:9097/api/movies"))
                .build();
    }
}
