package com.calog.repository;

import com.calog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    //id 중복여부 체크
    Boolean existsByUserId(String userId);
    User findByUserId(String userId);

}
