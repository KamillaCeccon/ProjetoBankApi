package com.bank.api.service;

import com.bank.api.exception.AccountNotFound;
import com.bank.api.model.Account;
import com.bank.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account deposit(Long destination, Double amount, boolean createNewAccount) {
        Account account;
        Optional<Account> existingAccount = accountRepository.findById(destination);
        if (existingAccount.isPresent()) {
            account = existingAccount.get();
            account.setBalance(account.getBalance() + amount);
        } else {
            if (createNewAccount) {
                account = new Account();
                account.setAccountId(destination);
                account.setBalance(amount);
            } else {
                throw new AccountNotFound("Conta não encontrada");
            }
        }
        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(Long origin, Double amount) {
        Account account;
        Optional<Account> existingAccount = accountRepository.findById(origin);
        if (existingAccount.isPresent()) {
            account = existingAccount.get();
            account.setBalance(account.getBalance() - amount);
            return accountRepository.save(account);
        } else {
            throw new AccountNotFound("Conta não encontrada");
        }

    }

    @Override
    public Optional<Account> getAccount(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }
}
