package com.calog.model.dto;

public class Detail {
    private int id;
    private String category;
    private int eventId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", eventId=" + eventId +
                '}';
    }
}
