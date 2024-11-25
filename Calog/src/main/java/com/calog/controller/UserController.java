package com.calog.controller;

import com.calog.model.dto.LoginRequest;
import com.calog.model.dto.ParticipationRequest;
import com.calog.model.dto.User;
import com.calog.model.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //쿠키는 정상적으로 도착함
    @GetMapping("/test")
    public ResponseEntity<String> test(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie: " + cookie.getName() + " = " + cookie.getValue());
            }
        }
        return ResponseEntity.ok("Cookies logged");
    }

    //회원가입
    @PostMapping("")
    public ResponseEntity<?> join(@RequestBody User user) {
        if (userService.isUserExist(user.getUserId())){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The ID is already registered.");
        }
        boolean result = userService.signup(user);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("User inserted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest,HttpServletResponse response) {
        User user = userService.login(loginRequest.getUserId(), loginRequest.getUserPw());
        if (user != null) {

//

            Cookie cookie = new Cookie("LogIn", user.getUserId()); //브라우저 세션
            //HTTP 전송만 허용하여 JavaScript 같은 클라이언트 스크립트에서 쿠키에 접근하지 못하게 설정 (보안 강화)
            cookie.setHttpOnly(true);
            // 쿠키의 유효 경로를 웹 애플리케이션 전체("/")로 설정하여 모든 요청 경로에서 사용 가능하도록 함
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60);

            //설정한 쿠키를 HTTP 응답에 추가하여 클라이언트에게 전송
            response.addCookie(cookie);
           return ResponseEntity.status(HttpStatus.OK).body(user);
       } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed: 다시 로그인하세요");
        }
//
    }

    @GetMapping("/check-login")
    public ResponseEntity<?> checkLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("LogIn".equals(cookie.getName())) {
                    return ResponseEntity.ok(cookie.getValue());
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("LogIn", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK).body("Logged out");
    }




    @GetMapping("/getAll")
    public ResponseEntity<?>getAllUser(){
        List<User> result = userService.getAllUser();
        if (result.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }




}
