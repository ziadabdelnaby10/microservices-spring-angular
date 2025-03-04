package com.example.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI productServiceAPI() {
        return new OpenAPI()
                .info(
                        new Info().title("Product Service API")
                                .description("This is the REST API for Product Service")
                                .version("1.0.0")
                                .license(new License().name("Apache 2.0")))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("You can refer to the Product Service Wiki Documentation")
                                .url("https://www.google.com")
                );
    }
}
