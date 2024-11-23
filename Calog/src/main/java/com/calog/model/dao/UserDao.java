package com.calog.model.dao;

import com.calog.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    boolean insertUser(User user);
    User findById(String userId);
    List<User> selectAllUser();

}
