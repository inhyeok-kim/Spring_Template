package com.sea.weed.config.web;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
    //     // Spring Security를 적용하지 않을 리소스를 설정한다.

    //     return web -> {
    //         web.ignoring()
    //             .antMatchers(
    //                 "/api-document/**",
    //                 "/swagger-ui/**"
    //                 );
    //     };
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().configurationSource(corsConfigurationSource());
        http.headers().xssProtection();
        
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // setAllowCredentials : cross origin 으로부터 인증을 위한 쿠키 정보를 받을지 여부.
        // setAllowedOrigins : 허용할 origin 정보.
        // setAllowedMethods : 허용할 http methods.
        configuration.setAllowCredentials(false); // 쿠키를 받을건지
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
}
