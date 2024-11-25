//package com.calog.model.service;
//
//import com.calog.Entity.User;
//import com.calog.model.dto.JoinDTO;
//import com.calog.repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JoinService {
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//    public Boolean joinProcess(JoinDTO joinDTO){
//        String userId = joinDTO.getUserId();
//        String userPw = joinDTO.getUserPw();
//        String nickname = joinDTO.getNickname();
//
//        Boolean isExist = userRepository.existsByUserId(userId);
//        if (isExist){
//            return false;
//        }
//        User data = new User();
//        data.setUserId(userId);
//        data.setUserPw(bCryptPasswordEncoder.encode(userPw));
//        data.setNickname(nickname);
//        userRepository.save(data);
//        return true;
//    }
//}
