package com.calog.model.service;

import com.calog.model.dto.User;

public interface UserService {
    public boolean signup(User user);
    public User login(String userId, String userPw);
    public boolean isUserExist(String userId);

}
