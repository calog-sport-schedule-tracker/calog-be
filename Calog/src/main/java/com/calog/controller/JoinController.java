package com.calog.controller;

import com.calog.model.dto.JoinDTO;
import com.calog.model.service.JoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    private final JoinService joinService;
    public JoinController(JoinService joinService){
        this.joinService =joinService;
    }
    @PostMapping("/api/join")
    public ResponseEntity<?> joinProcess(@RequestBody JoinDTO joinDTO){
        boolean result = joinService.joinProcess(joinDTO);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("User inserted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
    }
}
