package com.calog.model.dto;

import java.time.LocalTime;

public class ParticipationRequest {
    private int userId; // 필수
    private int eventId; // 필수
    private String memo; // 선택
    private LocalTime completionTime; // 선택
    private Integer ranking; // 선택
    private String img; // 선택
    private String detail; // 선택

    // Getter와 Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) { // setter 이름 수정
        this.memo = memo;
    }

    public LocalTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalTime completionTime) {
        this.completionTime = completionTime;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
