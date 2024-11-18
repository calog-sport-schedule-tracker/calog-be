package com.calog.model.dto;


import java.util.Date;

public class Event {
    private int id;
    private String eventName;
    private String sport;
    private Date eventDate;
    private String address;
    private String city;
    private Date registrationStart;
    private Date registrationDeadline;
    private String img;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport = sport; }
    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Date getRegistrationStart() { return registrationStart; }
    public void setRegistrationStart(Date registrationStart) { this.registrationStart = registrationStart; }
    public Date getRegistrationDeadline() { return registrationDeadline; }
    public void setRegistrationDeadline(Date registrationDeadline) { this.registrationDeadline = registrationDeadline; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", sport='" + sport + '\'' +
                ", eventDate=" + eventDate +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", registrationStart=" + registrationStart +
                ", registrationDeadline=" + registrationDeadline +
                ", img='" + img + '\'' +
                '}';
    }
}
