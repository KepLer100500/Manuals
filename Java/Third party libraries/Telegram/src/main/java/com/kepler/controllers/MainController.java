package com.kepler.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kepler.model.ChatRequest;
import com.kepler.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {
    @Autowired
    private AIService aiService;
    
    @PostMapping("/")
    public ResponseEntity<String> processMessage(@RequestBody ChatRequest chatRequest) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(aiService.process(chatRequest.getMessage()));
    }
}
