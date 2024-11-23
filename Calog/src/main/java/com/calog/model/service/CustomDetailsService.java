package com.calog.model.service;

import com.calog.Entity.User;
import com.calog.model.dto.CustomUserDetails;
import com.calog.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        User userData = userRepository.findByUserId(userId);
        System.out.println("UserId: " + userId);
        System.out.println("UserData: " + userData);



        if (userData == null) {
            throw new UsernameNotFoundException("해당 아이디로 데이터 없음: " + userId);
        }


        // CustomUserDetails 객체 반환
        return new CustomUserDetails(userData);
    }
}
