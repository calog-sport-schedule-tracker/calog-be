package com.calog.model.service;

import com.calog.model.dao.ParticipationDao;
import com.calog.model.dto.Participation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ParticipationServiceImpl implements ParticipationService {
    @Autowired
    ParticipationDao pd;
    @Override
    public List<Participation> getAllParticipationByUserId(int userId) {
        System.out.println("유저의 모든 참여 기록 조회");
        return pd.selectAllByUserId(userId);
    }

    @Override
    public List<Participation> getParticipationBySport(int userId, String sport) {
        System.out.println("대회 종목 별 참여 기록 조회");

        return pd.selectByUserIdFiltSport(userId, sport);
    }

    @Override
    public List<Participation> getParticipationByMonth(int userId, int eventYear, int eventMonth) {
        System.out.println("월 별 대회 참여 기록 조회");
        return pd.selectByUserIdFiltMonth(userId, eventYear, eventMonth);

    }

    @Override
    public List<Participation> getParticipationByCity(int userId, String city) {
        System.out.println("대회 참여 장소 별 기록 조회");
        return pd.selectByUserIdFiltCity(userId,  city);
    }

    @Override
    public List<Participation> getParticipationBySportAndMonth(int userId, String sport, int eventYear, int eventMonth) {
        System.out.println("대회 참여 종목&날짜 별 기록 조회");
        return pd.selectByUserIdFiltSportAndMonth(userId,  sport, eventYear, eventMonth);
    }

    @Override
    public List<Participation> getParticipationBySportAndCity(int userId, String sport, String city) {
        System.out.println("대회 참여 종목&도시 별 기록 조회");
        return pd.selectByUserIdFiltSportAndCity(userId,sport,city);
    }

    @Override
    public List<Participation> getParticipationByMonthAndCity(int userId, int eventYear, int eventMonth, String city) {
        System.out.println("대회 참여 날짜&도시 별 기록 조회");
        return pd.selectByUserIdFiltMonthAndCity(userId,eventYear,eventMonth,city);
    }

    @Override
    public List<Participation> getParticipationBySportAndMonthAndCity(int userId, String sport, int eventYear, int eventMonth, String city ) {
        System.out.println("대회 참여 종목&날짜&도시 별 기록 조회");
        return pd.selectByUserIdFiltSportAndMonthAndCity(userId,sport,eventYear,eventMonth,city);
    }

    @Override
    public Participation getOneParticipation(int userId, int id) {
        System.out.println("참여 기록 하나 조회");
        return pd.selectParticipationById(userId,id);
    }

    @Override
    public boolean writeParticipation(Participation participation, int userId) {
        System.out.println("참여 기록 삽입");
        if (pd.insertParticipation(participation,userId)){
            System.out.println("성공");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateParticipation(int userId,int id, Map<String, Object> updates) {
        if (updates == null || updates.isEmpty()) {
            return false;
        }
        return pd.updateParticipation(userId,id, updates);
    }

    @Override
    public boolean deleteParticipation(int userId,int id){
        return pd.deleteParticipation(userId,id);
    }
}
