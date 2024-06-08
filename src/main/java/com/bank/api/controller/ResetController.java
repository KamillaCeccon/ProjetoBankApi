package com.bank.api.controller;

import com.bank.api.service.BalanceService;
import com.bank.api.service.ResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reset")
public class ResetController {
    @Autowired
    private ResetService resetService;

    @PostMapping
    public ResponseEntity<Void> resetData() {
        resetService.resetData();
        return ResponseEntity.ok().build();
    }

}
