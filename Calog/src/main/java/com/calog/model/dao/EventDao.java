package com.calog.model.dao;

import com.calog.model.dto.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EventDao {
    List<Event>selectAllEvent();
    List<Event>selectEventByMonth(@Param("eventYear") int eventYear, @Param("eventMonth") int eventMonth);
    List<Event>selectEventBySport(@Param("eventYear")int eventYear, @Param("eventMonth")int eventMonth, @Param("sport")String sport);
    List<Event>selectEventByCity(@Param("eventYear")int eventYear, @Param("eventMonth")int eventMonth, @Param("city")String city);
    List<Event>selectEventBySportAndCity(@Param("eventYear")int eventYear, @Param("eventMonth")int eventMonth, @Param("sport")String sport,@Param("city")String city);

    List<Event>selectEventByDate(@Param("eventYear") int eventYear, @Param("eventMonth") int eventMonth, @Param("eventDay")int eventDay);
    Event selectOneEvent(@Param("id")int id);


}
