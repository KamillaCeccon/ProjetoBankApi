package com.bank.api.controller;

import com.bank.api.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    @GetMapping
    public ResponseEntity<Integer> getBalance(@RequestParam(name = "account_id") String accountId) {
        return new ResponseEntity<Integer>(balanceService.getBalance(Long.parseLong(accountId)).intValue(), HttpStatus.OK);
    }

}
