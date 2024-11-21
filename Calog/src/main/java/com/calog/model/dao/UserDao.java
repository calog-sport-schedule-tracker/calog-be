package com.calog.model.dao;

import com.calog.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    boolean insertUser(User user);
    User findById(String userId);

}
