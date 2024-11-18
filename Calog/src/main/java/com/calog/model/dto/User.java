package com.calog.model.dto;

public class User {
    private int id;
    private String userId;
    private String userPw;
    private String nickname;

    public User(){};
    public User(String userId, String userPw, String nickname) {

        this.userId = userId;
        this.userPw = userPw;
        this.nickname = nickname;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserPw() { return userPw; }
    public void setUserPw(String userPw) { this.userPw = userPw; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
}
