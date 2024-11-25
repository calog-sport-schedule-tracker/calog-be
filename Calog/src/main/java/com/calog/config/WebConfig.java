package com.calog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 엔드포인트에 대해 CORS 설정
                .allowedOrigins("http://localhost:8080") // Vue.js 애플리케이션 Origin
                .allowedOrigins(("http://localhost:5173"))
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // 허용 HTTP 메서드
                //.allowedHeaders("*") // 모든 헤더 허용
                .exposedHeaders("Authorization") // 클라이언트가 접근 가능한 헤더
                .allowCredentials(true); // 쿠키 및 인증 정보 허용
    }
}
