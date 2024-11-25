//package com.calog.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173") // 정확한 Origin 설정
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS","PATCH")
//                .allowedHeaders("*")
//                .exposedHeaders("Authorization")
//                .allowCredentials(true); // 인증 정보 허용
//    }
////}
