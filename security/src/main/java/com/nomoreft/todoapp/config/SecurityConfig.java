package com.nomoreft.todoapp.config;

import com.nomoreft.todoapp.web.servlet.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public static final String API_PUBLIC_URLS = "/api/v1/guest/**";
    public static final String API_GENERAL_URLS = "/api/v1/member/**";
    public static final String API_MANAGER_URLS = "/api/v1/manager/**";
    public static final String API_ADMIN_URLS = "/api/v1/admin/**";
    public static final String API_COMMON_URLS = "/api/v1/common/**";

    public static final String[] STATIC_URLS = new String[]{
            "/",
            "/signin",
            "/app.webmanifest",
            "/index.html",
            "/invite/**",
            "/images/**",
            "/assets/**",
            "/front/**",
            "/admin/**",
            "/locales/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/favicon.ico",
            "/manifest.json",
    };

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().requestMatchers(STATIC_URLS);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(API_COMMON_URLS).permitAll()
                        .requestMatchers(API_GENERAL_URLS).permitAll()
                        .requestMatchers(API_MANAGER_URLS).permitAll()
                        .requestMatchers(API_ADMIN_URLS).permitAll()
                        .requestMatchers(API_PUBLIC_URLS).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}