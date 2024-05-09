package net.javaguide.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
