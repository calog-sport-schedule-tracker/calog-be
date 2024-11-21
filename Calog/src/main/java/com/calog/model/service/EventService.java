package com.calog.model.service;

import com.calog.model.dto.Event;

import java.util.Date;
import java.util.List;

public interface EventService {
    public List<Event>getAllEvent();
    public List<Event>getEventByMonth(int eventYear, int eventMonth);
    public List<Event>getEventBySport(int eventYear, int eventMonth, String sport);
    public List<Event>getEventByCity(int eventYear, int eventMonth, String city);
    public List<Event>getEventBySportAndCity(int eventYear, int eventMonth, String sport, String city);
    public List<Event>getEventByDate(int eventYear, int eventMonth, int eventDay);
    public Event getOneEvent(int id);


}
