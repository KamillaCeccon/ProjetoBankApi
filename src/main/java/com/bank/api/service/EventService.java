package com.bank.api.service;

import com.bank.api.dto.EventRequestDto;
import com.bank.api.dto.EventResponseDto;

public interface EventService {

    public EventResponseDto executeTransaction(EventRequestDto eventRequestDto);
}
