package com.bank.api.service;

import com.bank.api.exception.AccountNotFound;
import com.bank.api.model.Account;
import com.bank.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private AccountService accountService;

    @Override
    public Double getBalance(Long accountId) {
        Optional<Account> account = accountService.getAccount(accountId);
        if (account.isPresent()) {
            return account.get().getBalance();
        }else{
            throw new AccountNotFound("Conta não encontrada");
        }


    }
}
