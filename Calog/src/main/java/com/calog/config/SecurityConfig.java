package com.calog.config;

import com.calog.jwt.JWTFilter;
import com.calog.jwt.JWTUtil;
import com.calog.jwt.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JWTUtil jwtUtil;
    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, JWTUtil jwtUtil){
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil = jwtUtil;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // CSRF 비활성화
        http.csrf(csrf -> csrf.disable());


        //From 로그인 방식 disable
        http
                .formLogin((auth) -> auth.disable());


        //http basic 인증 방식 disable
        http
                .httpBasic((auth)-> auth.disable());

        //인가 작업.
        http
                .authorizeHttpRequests(auth -> auth
                        //여기는 로그인 안해도 접근가능한 path넣기
                        .anyRequest().permitAll()
                );





        // 세션 설정 (세션을 stateless로 관리. 가장 중요!!)
        http
                .sessionManagement((session)->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
