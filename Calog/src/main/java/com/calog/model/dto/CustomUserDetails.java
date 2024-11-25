//package com.calog.model.dto;
//
//import com.calog.Entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class CustomUserDetails implements UserDetails {
//    private final User userEntity;
//    public CustomUserDetails(User userEntity){
//        this.userEntity = userEntity;
//    }
//
//
//    public String getNickname() {
//        return userEntity.getNickname();
//    }
//
//    // User 엔티티 자체를 반환
//    public User getUserEntity() {
//        return userEntity;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return userEntity.getUserPw();
//    }
//
//    @Override
//    public String getUsername() {
//        return userEntity.getUserId(); //우린 userName이 아니라 userId로 로그인 할 예정..
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
