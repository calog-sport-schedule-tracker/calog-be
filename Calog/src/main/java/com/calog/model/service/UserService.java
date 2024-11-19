package com.calog.model.service;

import com.calog.model.dto.User;

public interface UserService {
    public boolean signup(User user);
    public User login(String userId, String userPw);

    public boolean logout(User user);
    public boolean isUserExist(String userId);

}
