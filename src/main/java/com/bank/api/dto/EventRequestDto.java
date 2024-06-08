package com.bank.api.dto;

import lombok.Data;

@Data
public class EventRequestDto {

    private String type;
    private String origin;
    private String destination;
    private Double amount;

}
