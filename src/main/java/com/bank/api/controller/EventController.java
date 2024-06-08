package com.bank.api.controller;

import com.bank.api.dto.EventRequestDto;
import com.bank.api.dto.EventResponseDto;
import com.bank.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDto> executeTransaction(@RequestBody EventRequestDto eventRequestDto) {
        return new ResponseEntity<EventResponseDto>(eventService.executeTransaction(eventRequestDto), HttpStatus.CREATED);

    }
}
