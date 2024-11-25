//package com.calog.jwt;
//
//import com.calog.model.dto.CustomUserDetails;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.util.Map;
//
////이 필터를 사용하려면 config에 등록해줘야 함
//public class LoginFilter extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//    private final JWTUtil jwtUtil;
//    public LoginFilter(AuthenticationManager authenticationManager,JWTUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.setFilterProcessesUrl("/api/login");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            // JSON 요청에서 데이터 파싱
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, String> loginData = objectMapper.readValue(request.getInputStream(), Map.class);
//
//            String userId = loginData.get("userId");
//            String userPw = loginData.get("userPw");
//            String nickname = loginData.get("nickname");
//            System.out.println(nickname);
//
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(userId, userPw);
//
//            // AuthenticationManager에게 인증 요청
//            return authenticationManager.authenticate(authenticationToken);
//        } catch (IOException e) {
//            throw new RuntimeException("로그인 요청 처리 중 오류 발생", e);
//        }
//
//
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication){
//        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//
//        String userId = customUserDetails.getUsername();
//        String nickname = customUserDetails.getNickname();
//
//        // 토큰 생성
//        String token = jwtUtil.createJwt(userId, nickname, 60 * 60 * 10L);
//        System.out.println("Generated Token: " + token);
//
//        // 토큰 추가
//
//        //인증 방식 붙이고 띄어쓰기 필수임!!!
//        //Http 인증방식은 RFC7235 정의에 따라 이게 규칙!!
//        response.addHeader("Authorization", "Bearer " + token);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed){
//        System.out.println("로그인 실패");
//        response.setStatus(401);
//
//    }
//}
