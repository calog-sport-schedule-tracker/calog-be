package com.calog.controller;

import com.calog.model.dao.FavoriteDao;
import com.calog.model.dto.Event;
import com.calog.model.dto.User;
import com.calog.model.service.DetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteDao fd;

    public FavoriteController(FavoriteDao fd){
        this.fd = fd;
    }

    //찜 추가 요청 (true 나오면 성공적으로 추가됐다는 뜻. 근데 이미 찜 처리 되어있는데 다시 추가 요청하면 false 반환)
    @PostMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<?> addFavorite(@PathVariable("userId") int userId,@PathVariable("eventId")int eventId){
        if (fd.checkFavorite(userId,eventId)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
        else{
            fd.insertFavorite(eventId,userId);
            return ResponseEntity.ok(true);
        }
    }

    //찜 해제 요청 (true나오면 정상적으로 찜 해제. 근데 false나오면 찜처리가 안되어있는데 해제를 요청한다는 뜻)
    @DeleteMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<?> deleteFavorite(@PathVariable("userId") int userId,@PathVariable("eventId")int eventId){
        if (fd.checkFavorite(userId,eventId)){
            boolean result = fd.deleteFavorite(eventId,userId);
            if (result){
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    //여기로 요청 보내서 true나오면 찜 O, false누르면 찜X 상태라는 뜻.
    @GetMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<?> checkFavorite(@PathVariable("userId")int userId, @PathVariable("eventId")int eventId){
        return ResponseEntity.ok(fd.checkFavorite(userId,eventId));
    }

    //사용자가 찜 처리한 모든 이벤트 끌고오는 요청 (이걸로 이미 캘린더 띄움)
    @GetMapping("/user/{userId}")
    public ResponseEntity<?>getAllFavoriteEvent(@PathVariable("userId")int userId){
        List<Event>result = fd.selectFavoritesByUser(userId);
        if (result.size()!=0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.noContent().build();
    }
}
