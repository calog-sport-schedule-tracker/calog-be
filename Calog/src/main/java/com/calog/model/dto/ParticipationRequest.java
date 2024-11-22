package com.calog.model.dto;

import java.time.LocalTime;
import java.util.Date;

public class ParticipationRequest {
    private int userId; // 필수
    private int eventId; // 필수
    private String record; // 선택
    private LocalTime completionTime; // 선택
    private Integer ranking; // 선택
    private String img; // 선택
    private String detail;



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

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
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
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
}
