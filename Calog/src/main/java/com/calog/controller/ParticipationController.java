package com.calog.controller;

import com.calog.model.dto.Participation;
import com.calog.model.dto.ParticipationRequest;
import com.calog.model.service.ParticipationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
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

    @GetMapping("/user/{userId}/participation/sportCity")
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
    @GetMapping("/user/{userId}/participation/dateCity")
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
    @GetMapping("/user/{userId}/participation/sportDateCity")
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
    public ResponseEntity<?> createParticipation(@RequestBody ParticipationRequest request) {
        // Participation 객체 생성
        Participation participation = new Participation();
        participation.setUserId(request.getUserId());
        participation.setEventId(request.getEventId());
        participation.setMemo(request.getMemo());
        participation.setCompletionTime(request.getCompletionTime());
        participation.setRanking(request.getRanking());
        participation.setImg(request.getImg());
        participation.setDetail(request.getDetail());
        participation.setUpdatedAt(LocalDateTime.now());

        boolean isCreated = participationService.writeParticipation(participation, request.getUserId());
        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Participation successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create participation");
        }
    }

    @PatchMapping("/user/{userId}/participation/{id}")
    public ResponseEntity<?> updateParticipation(
            @PathVariable("userId")int userId,
            @PathVariable("id") int id,
            @RequestBody ParticipationRequest updates
    ) {

        boolean isUpdated = participationService.updateParticipation(userId,id, updates);

        if (isUpdated) {
            return ResponseEntity.ok("Participation successfully updated");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update participation");
        }
    }

    @DeleteMapping("/user/{userId}/participation/{id}")
    public ResponseEntity<?> deleteParticipation(@PathVariable("userId")int userId,@PathVariable("id") int id) {

        boolean isDeleted = participationService.deleteParticipation(userId,id);

        if (isDeleted) {
            return ResponseEntity.ok("Participation successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participation not found or failed to delete");
        }

    }

    @GetMapping("/user/{userId}/participation/{id}")
    public ResponseEntity<?>getOneParticipation(@PathVariable("userId")int userId, @PathVariable("id")int id){
        Participation result = participationService.getOneParticipation(userId,id);

        if (result!=null){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/participation/marathon")
    public ResponseEntity<?>getUserMarathon(@PathVariable("userId")int userId){
        int result = participationService.getUserParticipationSum(userId,"마라톤");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}/participation/tennis")
    public ResponseEntity<?>getUserTennis(@PathVariable("userId")int userId){
        int result = participationService.getUserParticipationSum(userId,"테니스");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}/participation/badminton")
    public ResponseEntity<?>getUserBadminton(@PathVariable("userId")int userId){
        int result = participationService.getUserParticipationSum(userId,"배드민턴");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}/participation/granfondo")
    public ResponseEntity<?>getUserGranfondo(@PathVariable("userId")int userId){
        int result = participationService.getUserParticipationSum(userId,"그랑폰도");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}/participation/triathlon")
    public ResponseEntity<?>getUserTriathlon(@PathVariable("userId")int userId){
        int result = participationService.getUserParticipationSum(userId,"철인3종");
        return ResponseEntity.ok(result);
    }





}
