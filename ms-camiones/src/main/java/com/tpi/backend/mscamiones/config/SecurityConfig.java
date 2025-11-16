package com.tpi.backend.mscamiones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 1. Creamos nuestro convertidor personalizado de JWT
        JwtAuthConverter jwtAuthConverter = new JwtAuthConverter();

        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    // REGLA 1: Solo 'admin' puede crear, actualizar o validar
                    .requestMatchers(HttpMethod.POST, "/api/v1/camiones", "/api/v1/camiones/validar-capacidad", "/api/v1/transportistas").hasAuthority("admin")
                    .requestMatchers(HttpMethod.PUT, "/api/v1/camiones/**").hasAuthority("admin")

                    // REGLA 2: 'admin' y 'cliente' pueden VER camiones
                    .requestMatchers(HttpMethod.GET, "/api/v1/camiones").hasAnyAuthority("admin", "cliente")

                    // REGLA 3: Permitir acceso a Swagger (si no, da 401)
                    .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                    // REGLA 4: Negar todo lo demás
                    .anyRequest().denyAll()
            )
            // 2. Le decimos a Spring que use nuestro convertidor
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)))

            .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}