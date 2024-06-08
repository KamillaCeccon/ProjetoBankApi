package com.bank.api.service;

import com.bank.api.model.Account;

import java.util.Optional;

public interface AccountService {

    public Account deposit(Long destination, Double amount);
    public Account withdraw(Long origin, Double amount);
    public Optional<Account> getAccount(Long accountId);
}
