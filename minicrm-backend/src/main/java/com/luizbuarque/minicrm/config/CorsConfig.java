package com.luizbuarque.minicrm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow cross-origin requests for all paths
                registry.addMapping("/**")
                        // Allow requests from these origins (update with your frontend URL)
                        .allowedOrigins("http://localhost:5173", "http://localhost:8080")
                        // Allow these HTTP methods
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allow any headers
                        .allowedHeaders("*")
                        // Optionally allow credentials (cookies, authorization headers, etc.)
                        .allowCredentials(true);
            }
        };
    }
}
