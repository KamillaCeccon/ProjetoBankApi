package com.bank.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @Column(name = "account_id", nullable = false)
    private Long accountId; //account_id
    @Column(nullable = false)
    private Double balance;

}
