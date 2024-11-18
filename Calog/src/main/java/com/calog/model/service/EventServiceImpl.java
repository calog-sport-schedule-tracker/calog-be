package com.calog.model.service;

import com.calog.model.dao.EventDao;
import com.calog.model.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDao ed;

    @Override
    public List<Event> getAllEventByMonth(Date eventDate) {
        System.out.println("월별 대회 조회");
        List<Event>result = ed.selectEventByDate(eventDate);
        return result;

    }

    @Override
    public List<Event> getEventByDate(Date eventDate) {
        System.out.println("특정 날짜 대회 조회");
        List<Event>result = ed.selectEventByDate(eventDate);
        return null;
    }

    @Override
    public List<Event> getEventByCity(Date eventDate, String city) {

        return null;
    }

    @Override
    public List<Event> getEventBySport(Date eventDate, String Sport) {
        return null;
    }
}
