package com.calog.controller;

import com.calog.model.dto.User;
import com.calog.model.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @PostMapping()
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
    public ResponseEntity<?> login(@RequestBody User loginRequest, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.login(loginRequest.getUserId(), loginRequest.getUserPw());
        if (user != null) {


            //나중에 jwt로 바꾸겠습니다.
            Cookie cookie = new Cookie("LogIn", user.getUserId()); //브라우저 세션
            //HTTP 전송만 허용하여 JavaScript 같은 클라이언트 스크립트에서 쿠키에 접근하지 못하게 설정 (보안 강화)
            cookie.setHttpOnly(true);
            // 쿠키의 유효 경로를 웹 애플리케이션 전체("/")로 설정하여 모든 요청 경로에서 사용 가능하도록 함
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60);

            //설정한 쿠키를 HTTP 응답에 추가하여 클라이언트에게 전송
            response.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("User Logined");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed: 다시 로그인하세요");
        }

    }


}
