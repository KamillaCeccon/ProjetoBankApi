package com.bank.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetServiceImpl implements  ResetService{
    @Autowired
    private AccountService accountService;
    @Override
    public void resetData() {
    accountService.deleteAllAccounts();
    }
}
