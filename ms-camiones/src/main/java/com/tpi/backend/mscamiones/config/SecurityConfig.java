package com.tpi.backend.mscamiones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    // Permitimos todas las peticiones por ahora para desarrollo
                    .anyRequest().permitAll() 
            )
            // Deshabilitamos CSRF para poder probar con Postman/Thunder Client
            .csrf(AbstractHttpConfigurer::disable); 

        return http.build();
    }
}