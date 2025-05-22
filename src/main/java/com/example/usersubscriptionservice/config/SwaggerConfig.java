package com.example.usersubscriptionservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI userSubscriptionServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Subscription Service API")
                        .description("REST API для управления пользователями и их подписками")
                        .version("1.0.0"));
    }
}
