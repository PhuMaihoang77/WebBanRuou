package com.wineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//    Nếu KHÔNG có SecurityConfig:
//    Spring Security bật mặc định chế độ bảo mật, yêu cầu authentication cho mọi request.
//
//    Các request từ React sẽ bị trả về 401 Unauthorized hoặc yêu cầu đăng nhập nếu không cung cấp
//    thông tin đăng nhập.
//
//    CSRF protection cũng mặc định bật, điều này sẽ gây lỗi cho các POST/PUT/DELETE request từ frontend,
//    đặc biệt là khi frontend không gửi token CSRF.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF cho test API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // Cho phép tất cả /api/*
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // hoặc .formLogin().disable()
        return http.build();
    }
}
