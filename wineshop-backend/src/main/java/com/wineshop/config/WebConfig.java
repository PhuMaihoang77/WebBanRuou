package com.wineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    //❌ Nếu KHÔNG có WebConfig (CORS configuration):
//    Trình duyệt sẽ chặn các request từ React frontend (chạy ở localhost:3000) tới backend (ví dụ localhost:8080)
//    do vi phạm chính sách CORS (Cross-Origin Resource Sharing).
//
//    Mặc định, Spring Boot không cho phép cross-origin requests trừ khi bạn cấu hình cụ thể.
//
//    Bạn sẽ gặp lỗi CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Cho phép tất cả API
                        .allowedOrigins("http://localhost:8080") // Đổi nếu frontend ở cổng khác
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
