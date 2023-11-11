package com.trainingit.courses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(List.of(
                User.withUsername("user1")
                        .password("{noop}user1")
                        .roles("Invitado")
                        .build(),
                User.withUsername("user2")
                        .password("{noop}user2")
                        .roles("Operador")
                        .build(),
                User.withUsername("user3")
                        .password("{noop}user3")
                        .roles("Admin")
                        .build(),
                User.withUsername("user4")
                        .password("{noop}user4")
                        .roles("Operador", "Admin")
                        .build()));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST, "/course")
                        .hasRole("Admin")
                        .requestMatchers(HttpMethod.DELETE, "/course/*")
                        .hasAnyRole("Admin", "Operador")
                        .requestMatchers(HttpMethod.PUT, "/course/*")
                        .hasAnyRole("Admin", "Operador")
                        .requestMatchers(HttpMethod.GET).authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}
