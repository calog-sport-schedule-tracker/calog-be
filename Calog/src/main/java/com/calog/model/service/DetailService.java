package com.calog.model.service;

import com.calog.model.dto.Detail;

import java.util.List;

public interface DetailService {
    public List<Detail> getAllDetailByEventId(int eventId);
}
