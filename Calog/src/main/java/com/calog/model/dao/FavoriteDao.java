package com.calog.model.dao;


import com.calog.model.dto.Event;
import com.calog.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteDao {
    boolean insertFavorite(int eventId, int userId);
    boolean deleteFavorite(int eventId, int userId);
    boolean checkFavorite(int userId, int eventId);

    List<Event> selectFavoritesByUser(int userId);

    List<User> selectFavoritesByEvent(int eventId);

}
