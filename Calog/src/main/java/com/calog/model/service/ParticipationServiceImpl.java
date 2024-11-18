package com.calog.model.service;

import com.calog.model.dao.ParticipationDao;
import com.calog.model.dto.Participation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationServiceImpl implements ParticipationService {
    @Autowired
    ParticipationDao pd;
    @Override
    public List<Participation> getAllParticipationByUserId(int userId) {
        System.out.println("유저의 모든 참여 기록 조회");
        List<Participation>result = pd.selectAllByUserId(userId);
        if (result!=null){
            return result;
        }

        return null;
    }

    @Override
    public List<Participation> getParticipationBySport(int userId, int eventId) {
        System.out.println("대회 종목 별 참여 기록 조회");
        List<Participation>result = pd.selectByUserIdFiltSport(userId, eventId);
        return result;
    }

    @Override
    public List<Participation> getParticipationByMonth(int userId, int eventId) {
        System.out.println("월 별 대회 참여 기록 조회");
        List<Participation>result = pd.selectByUserIdFiltSport(userId, eventId);
        return result;

    }

    @Override
    public List<Participation> getParticipationByCity(int userId, int eventId) {
        System.out.println("대회 참여 장소 별 기록 조회");
        List<Participation>result = pd.selectByUserIdFiltSport(userId, eventId);
        return result;
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
}
