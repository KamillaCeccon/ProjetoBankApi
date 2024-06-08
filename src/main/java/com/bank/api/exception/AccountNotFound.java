package com.bank.api.exception;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String message){
        super(message);
    }

}
