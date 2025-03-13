package com.example.apigateway.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final String[] freeResourceUrls = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/api-docs/**",
            "/aggregate/**",
            "/actuator/prometheus",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                        authorize -> authorize.requestMatchers(freeResourceUrls).permitAll()
                                .anyRequest()
                                .authenticated()
                ).oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

    @Bean
    public OpenAPI gateWayServiceAPI() {
        return new OpenAPI()
                .info(
                        new Info().title("GateWay Service API")
                                .description("This is the REST API for GateWay Service")
                                .version("1.0.0")
                                .license(new License().name("Apache 2.0")))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("You can refer to the GateWay Service Wiki Documentation")
                                .url("https://www.google.com")
                );
    }
}
