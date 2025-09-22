package com.example.civa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad de la aplicación.
 *
 * Esta clase define usuarios en memoria y establece las reglas
 * de autorización para los endpoints de la API usando Spring Security.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */
@Configuration
public class SecurityConfig {

        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails admin = User
                    .withUsername("admin")
                    .password("{noop}1234")
                    .roles("ADMIN")
                    .build();

            UserDetails user = User
                    .withUsername("user")
                    .password("{noop}1234")
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(admin, user);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("api/bus/**").authenticated()
                            .anyRequest().permitAll()
                    )
                    .httpBasic(Customizer.withDefaults());

            return http.build();
        }
    }



