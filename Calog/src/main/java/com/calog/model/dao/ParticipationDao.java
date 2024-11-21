package com.calog.model.dao;

import com.calog.model.dto.Participation;
import com.calog.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ParticipationDao {
    boolean insertParticipation(@Param("participation") Participation participation, @Param("userId") int userId);
    boolean updateParticipation(@Param("userId") int userId,@Param("id") int id, @Param("updates") Map<String, Object> updates);
    boolean deleteParticipation(@Param("userId")int userId, @Param("id") int id);


    List<Participation> selectAllByUserId(int userId);
    List<Participation>  selectByUserIdFiltSport(@Param("userId")int userId,@Param("sport") String sport);
    List<Participation> selectByUserIdFiltMonth(@Param("userId")int userId, @Param("eventYear") int eventYear, @Param("eventMonth") int eventMonth);
    List<Participation> selectByUserIdFiltCity(@Param("userId")int userId, @Param("city") String city);

    List<Participation> selectByUserIdFiltSportAndMonth(@Param("userId")int userId, @Param("sport")String sport, @Param("eventYear") int eventYear, @Param("eventMonth") int eventMonth);

    List<Participation> selectByUserIdFiltSportAndCity(@Param("userId")int userId, @Param("sport") String sport, @Param("city") String city);
    List<Participation> selectByUserIdFiltMonthAndCity(@Param("userId")int userId, @Param("eventYear") int eventYear, @Param("eventMonth") int eventMonth, @Param("city") String city);

    List<Participation> selectByUserIdFiltSportAndMonthAndCity(@Param("userId")int userId, @Param("sport")String sport, @Param("eventYear") int eventYear, @Param("eventMonth") int eventMonth, @Param("city") String city );

    Participation selectParticipationById(@Param("userId")int userId, @Param("id")int id);


}
