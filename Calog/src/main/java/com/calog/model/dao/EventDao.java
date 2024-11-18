package com.calog.model.dao;

import com.calog.model.dto.Event;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface EventDao {
    List<Event>selectEventByDate(Date eventDate);
    List<Event>selectEventByDateFiltCity(Date eventDate, String city);
    List<Event>selectEventByDateFiltSport(Date eventDate, String sport);


}
