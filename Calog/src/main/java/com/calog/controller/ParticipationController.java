package com.calog.controller;

import com.calog.model.dto.Participation;
import com.calog.model.dto.ParticipationRequest;
import com.calog.model.service.ParticipationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ParticipationController {
    private final ParticipationService participationService;
    public ParticipationController(ParticipationService participationService){
        this.participationService = participationService;
    }
    @GetMapping("/user/{userId}/participation")
    public ResponseEntity<?>getAllList(@PathVariable("userId") int userId){
        List<Participation> result = participationService.getAllParticipationByUserId(userId);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/user/{userId}/participation/sport")
    public ResponseEntity<?>getListBySport(@PathVariable("userId") int userId,
                                           @RequestParam(value = "sport", required = false) String sport){
        List<Participation> result = participationService.getParticipationBySport(userId,sport);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/user/{userId}/participation/date")
    public ResponseEntity<?>getListByDate(@PathVariable("userId") int userId,
                                           @RequestParam(value = "eventDate", required = false) String eventDate){
        //날짜 parsing
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }

        List<Participation> result = participationService.getParticipationByMonth(userId,eventYear,eventMonth);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/user/{userId}/participation/city")
    public ResponseEntity<?>getListByCity(@PathVariable("userId") int userId,
                                          @RequestParam(value = "city", required = false) String city){

        List<Participation> result = participationService.getParticipationByCity(userId,city);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }



    @GetMapping("/user/{userId}/participation/sportDate")
    public ResponseEntity<?>getListByCity(@PathVariable("userId") int userId,
                                               @RequestParam(value = "sport", required = false) String sport,
                                               @RequestParam(value = "eventDate", required = false) String eventDate){
        //날짜 parsing
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Participation>result = participationService.getParticipationBySportAndMonth(userId,sport,eventYear,eventMonth);
        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);


    }

    @GetMapping("/{userId}/participation/sportCity")
    public ResponseEntity<?> getListBySportAndCity(
            @PathVariable("userId") int userId,
            @RequestParam(value = "sport", required = false) String sport,
            @RequestParam(value = "city", required = false) String city
    ) {
        List<Participation>result = participationService.getParticipationBySportAndCity(userId,sport,city);

        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{userId}/participation/dateCity")
    public ResponseEntity<?> getListByDateAndCity(
            @PathVariable("userId") int userId,
            @RequestParam(value = "eventDate", required = false) String eventDate,
            @RequestParam(value = "city", required = false) String city
    ) {
        //날짜 parsing
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Participation>result = participationService.getParticipationByMonthAndCity(userId,eventYear,eventMonth,city);

        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{userId}/participation/sportDateCity")
    public ResponseEntity<?> getParticipationBySportAndDateAndCity(
            @PathVariable("userId") int userId,
            @RequestParam(value = "sport", required = false) String sport,
            @RequestParam(value = "eventDate", required = false) String eventDate,
            @RequestParam(value = "city", required = false) String city
    ) {
        //날짜 parsing
        Integer eventYear = null;
        Integer eventMonth = null;
        if (eventDate != null && !eventDate.isEmpty()) {
            String[] parts = eventDate.split("-");
            eventYear = Integer.parseInt(parts[0]);
            eventMonth = Integer.parseInt(parts[1]);
        }
        List<Participation>result = participationService.getParticipationBySportAndMonthAndCity(userId,sport,eventYear,eventMonth,city);

        if (result.size()==0)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/participation")
    public ResponseEntity<?> createParticipation(@RequestBody ParticipationRequest request){
        // Participation 객체 생성
        Participation participation = new Participation();
        participation.setUserId(request.getUserId());
        participation.setEventId(request.getEventId());
        participation.setMemo(request.getRecord());
        participation.setCompletionTime(request.getCompletionTime());
        participation.setRanking(request.getRanking());
        participation.setImg(request.getImg());

        boolean isCreated = participationService.writeParticipation(participation,request.getUserId());
        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Participation successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create participation");
        }
    }

    @PatchMapping("/participation/{id}")
    public ResponseEntity<?> updateParticipation(
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> updates
    ) {
        // Service 호출
        boolean isUpdated = participationService.updateParticipation(id, updates);

        if (isUpdated) {
            return ResponseEntity.ok("Participation successfully updated");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update participation");
        }
    }

    @DeleteMapping("/participation/{id}")
    public ResponseEntity<?> deleteParticipation(@PathVariable("id") int id) {
        // Service 호출
        boolean isDeleted = participationService.deleteParticipation(id);

        if (isDeleted) {
            return ResponseEntity.ok("Participation successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participation not found or failed to delete");
        }
    }




}
