package net.javaguide.BankingApp.service;

import net.javaguide.BankingApp.dto.AccountDto;
import net.javaguide.BankingApp.model.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto amountDeposited(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
