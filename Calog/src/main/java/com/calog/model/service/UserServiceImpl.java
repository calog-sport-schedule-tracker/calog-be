package com.calog.model.service;

import com.calog.model.dao.UserDao;
import com.calog.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao ud;
    @Override
    public boolean signup(User user) {
        System.out.println("유저 삽입");
        if (ud.insertUser(user)) {
            return true;
        }
        return false;
    }

    @Override
    public User login(String id, String password) {
        User result = ud.findById(id);

        if (result == null) {
            System.out.println("해당 정보의 사용자 없음");
            return null;
        }

        if (result.getUserPw().equals(password)) {
            return result;
        }
        System.out.println("패스워드 불일치! 다시 로그인하세요");
        return null;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }

    @Override
    public boolean isUserExist(String userId) {
        User result = ud.findById(userId);
        if (result!=null) {
            return true;
        }
        return false;
    }
}
