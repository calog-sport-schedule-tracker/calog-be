package com.calog.model.dao;

import com.calog.model.dto.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EventDao {
    List<Event>selectEventByDate(Date eventDate);
    List<Event>selectEventByDateFiltCity(@Param("eventDate")Date eventDate,@Param("city") String city);
    List<Event>selectEventByDateFiltSport(@Param("eventDate")Date eventDate, @Param("city")String sport);


}
