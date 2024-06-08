package com.bank.api.service;

import com.bank.api.dto.DestinationDto;
import com.bank.api.dto.EventRequestDto;
import com.bank.api.dto.EventResponseDto;
import com.bank.api.dto.OriginDto;
import com.bank.api.model.Account;
import com.bank.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BalanceService balanceService;

    @Override
    public EventResponseDto executeTransaction(EventRequestDto eventRequestDto) {
        DestinationDto destinationDto = null;
        OriginDto originDto = null;

        String eventType = eventRequestDto.getType();

        Long destination = eventRequestDto.getDestination() == null ? null : Long.parseLong(eventRequestDto.getDestination());
        Long origin = eventRequestDto.getOrigin() == null ? null : Long.parseLong(eventRequestDto.getOrigin());
        switch (eventType) {
            case "deposit":
                Account deposit = accountService.deposit(destination, eventRequestDto.getAmount(), true);
                destinationDto = new DestinationDto();
                destinationDto.setId(eventRequestDto.getDestination());
                destinationDto.setBalance(deposit.getBalance().intValue());
                break;
            case "withdraw":
                Account withdraw = accountService.withdraw(origin, eventRequestDto.getAmount());
                originDto = new OriginDto();
                originDto.setId(eventRequestDto.getOrigin());
                originDto.setBalance(withdraw.getBalance().intValue());
                break;
            case "transfer":
                return transfer(eventRequestDto.getOrigin(), eventRequestDto.getDestination(), eventRequestDto.getAmount());

            default:
                return null;
        }

        return new EventResponseDto(originDto, destinationDto);
    }

    private EventResponseDto transfer(String origin, String destination, Double amount) {
        OriginDto originDto = new OriginDto();
        DestinationDto destinationDto = new DestinationDto();
        originDto.setId(origin);
        destinationDto.setId(destination);

        Long destinationLong = destination == null ? null : Long.parseLong(destination);
        Long originLong = origin == null ? null : Long.parseLong(origin);
        Account withdraw = accountService.withdraw(originLong, amount);
        Account deposit = accountService.deposit(destinationLong, amount, true);
        originDto.setBalance(withdraw.getBalance().intValue());
        destinationDto.setBalance(deposit.getBalance().intValue());

        return new EventResponseDto(originDto, destinationDto);
    }

}
