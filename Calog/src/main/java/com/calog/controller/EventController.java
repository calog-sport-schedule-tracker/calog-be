package com.calog.controller;

import com.calog.model.dto.Event;
import com.calog.model.service.EventService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventService es;

    public EventController(EventService es){
        this.es = es;
    }

    @GetMapping()
    public ResponseEntity<?>getAllEvent(){
        List<Event>result = es.getAllEvent();
        if (result.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/month")
    public ResponseEntity<?>getEventByMonth(@RequestParam(value = "eventDate", required = false) String eventDate){
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Event>result = es.getEventByMonth(eventYear,eventMonth);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }



    @GetMapping("/sport")
    public ResponseEntity<?>getEventBySport(@RequestParam(value = "eventDate", required = false) String eventDate,@RequestParam(value = "sport", required = false) String sport){
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Event>result = es.getEventBySport(eventYear,eventMonth,sport);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/city")
    public ResponseEntity<?>getEventByCity(@RequestParam(value = "eventDate", required = false) String eventDate,@RequestParam(value = "city", required = false) String city){
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Event>result = es.getEventByCity(eventYear,eventMonth,city);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sportCity")
    public ResponseEntity<?>getEventBySportAndCity(@RequestParam(value = "eventDate", required = false) String eventDate,@RequestParam(value = "sport", required = false) String sport,@RequestParam(value = "city", required = false) String city){
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Event>result = es.getEventBySportAndCity(eventYear,eventMonth,sport,city);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/day")
    public ResponseEntity<?>getEventByDay(@RequestParam (value = "eventDate", required = false) String eventDate){
        Integer eventYear = null;
        Integer eventMonth = null;
        Integer eventDay = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
            eventDay = Integer.parseInt(parts[2]);
        }
        List<Event>result = es.getEventByDate(eventYear,eventMonth,eventDay);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getOneEvent(@PathVariable("id") int id){
        Event result = es.getOneEvent(id);
        if (result==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }


}
