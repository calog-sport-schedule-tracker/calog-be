package com.calog.model.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Participation {
    private int id;
    private String memo;
    private LocalTime completionTime;
    private Integer ranking;
    private String img;

    private LocalDateTime updatedAt;
    private int eventId;
    private int userId;

    public Participation(int eventId, int userId) {
        this.eventId = eventId;
        this.userId = userId;
    }


    public Participation(int id, int eventId, int userId, String memo) {
        this(eventId, userId);
        this.memo = memo;
    }


    public Participation(int id, int eventId, int userId, String memo, LocalTime completionTime) {
        this(id, eventId, userId, memo);
        this.completionTime = completionTime;
    }


    public Participation(int id, int eventId, int userId, String memo, LocalTime completionTime, Integer ranking) {
        this(id, eventId, userId, memo, completionTime);
        this.ranking = ranking;
    }


    public Participation(int id, int eventId, int userId, String memo, LocalTime completionTime, Integer ranking, String img) {
        this(id, eventId, userId, memo, completionTime, ranking);
        this.img = img;
    }

    public Participation() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }
    public LocalTime getCompletionTime() { return completionTime; }
    public void setCompletionTime(LocalTime completionTime) { this.completionTime = completionTime; }
    public Integer getRanking() { return ranking; }
    public void setRanking(Integer ranking) { this.ranking = ranking; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
