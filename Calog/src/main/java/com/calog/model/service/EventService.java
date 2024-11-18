package com.calog.model.service;

import com.calog.model.dto.Event;

import java.util.Date;
import java.util.List;

public interface EventService {
    public List<Event>getAllEventByMonth(Date eventDate);
    public List<Event>getEventByDate(Date eventDate);

    public List<Event>getEventByCity(Date eventDate, String city);
    public List<Event>getEventBySport(Date eventDate, String Sport);
}
