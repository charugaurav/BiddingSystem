package com.gg.biddingsystem.app.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for testing purposes
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/**").permitAll() // Allow access to Product API without authentication
                        .anyRequest().authenticated() // Require authentication for all other endpoints
                );
        return http.build();
    }
}


