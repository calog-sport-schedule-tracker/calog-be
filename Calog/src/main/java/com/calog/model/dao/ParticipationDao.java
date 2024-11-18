package com.calog.model.dao;

import com.calog.model.dto.Participation;
import com.calog.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParticipationDao {
    boolean insertParticipation(@Param("participation") Participation participation, @Param("userId") int userId);
    List<Participation> selectAllByUserId(int userId);
    List<Participation>  selectByUserIdFiltSport(@Param("userId")int userId, @Param("eventId") int eventId);
    List<Participation> selectByUserIdFiltMonth(@Param("userId")int userId, @Param("eventId")int eventId);
    List<Participation> selectByUserIdFiltCity(@Param("userId")int userId, @Param("eventId")int eventId);

}
