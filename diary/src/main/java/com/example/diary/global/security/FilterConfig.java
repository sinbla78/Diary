package com.example.diary.global.security;

import com.example.diary.global.error.ExceptionFilter;
import com.example.diary.global.security.jwt.JwtFilter;
import com.example.diary.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    public void configure(HttpSecurity http) {
        JwtFilter jwtTokenFilter = new JwtFilter(jwtTokenProvider);
        ExceptionFilter exceptionFilter = new ExceptionFilter(objectMapper);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionFilter, JwtFilter.class);
    }
}
