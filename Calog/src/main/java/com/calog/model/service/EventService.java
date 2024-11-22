package com.calog.model.service;

import com.calog.model.dto.Detail;
import com.calog.model.dto.Event;

import java.util.Date;
import java.util.List;

public interface EventService {
    public List<Event>getAllEvent();
    public List<Event>getEventByMonth(int eventYear, int eventMonth);
    public List<Event>getEventBySport(String sport);
    public List<Event>getEventByCity( String city);
    public List<Event>getEventBySportAndCity( String sport, String city);
    public List<Event>getEventByDate(int eventYear, int eventMonth, int eventDay);
    public Event getOneEvent(int id);



}
