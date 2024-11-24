package com.calog.interceptor;

import com.calog.model.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 쿠키에서 SESSIONID 찾기
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("LogIn".equals(cookie.getName())) {
                   
                	String userId = cookie.getValue();
                	
                	if (userService.isUserExist(userId)) {
                		return true;
                	}
                }
            }
        }

        // 쿠키가 없거나 유효하지 않으면, 401 Unauthorized 응답을 반환
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized access");
        return false; // 요청을 중단
       
    }

}
