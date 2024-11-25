package com.calog.controller;

import com.calog.model.dto.Detail;
import com.calog.model.dto.Event;
import com.calog.model.service.DetailService;
import com.calog.model.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detail")
public class DetailController {
    private final DetailService ds;

    public DetailController(DetailService ds){
        this.ds = ds;
    }


    @GetMapping("/{eventId}")
    public ResponseEntity<?> getAllDetail(@PathVariable("eventId") int eventId){
        List<Detail> result = ds.getAllDetailByEventId(eventId);
        if (result.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

}
