package com.anas.accountservice.entities;

import com.anas.accountservice.enums.AccountType;
import com.anas.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString  @Builder @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id  
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
