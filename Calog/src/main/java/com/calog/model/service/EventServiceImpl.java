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
    public List<Event> getAllEvent() {
        System.out.println("전체 대회 조회");
        return ed.selectAllEvent();
    }

    @Override
    public List<Event> getEventByMonth(int eventYear, int eventMonth) {
        System.out.println("특정 달 대회 조회");
        return ed.selectEventByMonth(eventYear,eventMonth);
    }

    @Override
    public List<Event> getEventBySport(int eventYear, int eventMonth, String sport) {
        System.out.println("특정 달, 종목 별 대회 조회");
        return ed.selectEventBySport(eventYear,eventMonth,sport);
    }

    @Override
    public List<Event> getEventByCity(int eventYear, int eventMonth, String city) {
        System.out.println("특정 달, 장소 별 대회 조회");
        return ed.selectEventByCity(eventYear,eventMonth,city);
    }

    @Override
    public List<Event> getEventBySportAndCity(int eventYear, int eventMonth, String sport, String city) {
        System.out.println("특정 달, 종목과 장소 별 대회 조회");
        return ed.selectEventBySportAndCity(eventYear,eventMonth,sport,city);
    }

    @Override
    public List<Event> getEventByDate(int eventYear, int eventMonth, int eventDay) {
        System.out.println("특정 날짜 대회 조회");
        return ed.selectEventByDate(eventYear,eventMonth,eventDay);
    }

    @Override
    public Event getOneEvent(int id) {
        System.out.println("특정 대회 조회");
        return ed.selectOneEvent(id);
    }
}
