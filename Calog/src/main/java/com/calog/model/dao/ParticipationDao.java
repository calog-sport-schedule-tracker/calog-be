package com.calog.model.dao;

import com.calog.model.dto.Participation;
import com.calog.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParticipationDao {
    boolean insertParticipation(Participation participation, int userId);
    List<Participation> selectAllByUserId(int userId);
    List<Participation>  selectByUserIdFiltSport(int userId, int eventId);
    List<Participation> selectParticipationFiltMonth(int userId, int eventId);
    List<Participation> selectParticipationFiltCity(int userId, int eventId);



}
