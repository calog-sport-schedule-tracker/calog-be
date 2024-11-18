package com.calog.model.dao;

import com.calog.model.dto.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailDao {
    List<Detail> selectDetailByEventId(int eventId);

}
