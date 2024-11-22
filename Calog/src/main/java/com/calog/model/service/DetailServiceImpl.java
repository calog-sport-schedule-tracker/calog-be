package com.calog.model.service;

import com.calog.model.dao.DetailDao;
import com.calog.model.dto.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailServiceImpl implements  DetailService{
    @Autowired
    private DetailDao dd;
    @Override
    public List<Detail> getAllDetailByEventId(int eventId) {
        System.out.println("대회 상세 분야 전체 조회");
        return dd.selectAllDetail(eventId);
    }
}
