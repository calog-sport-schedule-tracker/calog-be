package com.calog.model.service;

import com.calog.model.dto.Participation;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ParticipationService {

    public boolean writeParticipation(Participation participation, int userId);

    public boolean updateParticipation(int userId,int id, Map<String, Object> updates);
    public List<Participation> getAllParticipationByUserId(int userId);

    //종목별
    public List<Participation> getParticipationBySport(int userId, String sport);

    //날짜별
    public List<Participation> getParticipationByMonth(int userId,  int eventYear, int eventMonth);

    //장소별
    public List<Participation> getParticipationByCity(int userId,  String city);

    //종목&날짜
    public List<Participation> getParticipationBySportAndMonth(int userId,  String sport,int eventYear, int eventMonth);

    //종목&장소
    public List<Participation> getParticipationBySportAndCity(int userId, String sport, String city);

    //날짜&장소
    public List<Participation> getParticipationByMonthAndCity(int userId, int eventYear, int eventMonth, String city);
    //종목&날짜&장소
    public List<Participation> getParticipationBySportAndMonthAndCity(int userId, String sport, int eventYear, int eventMonth, String city);

    public Participation getOneParticipation(int userId, int id);

    public boolean deleteParticipation(int userId,int id);
}
