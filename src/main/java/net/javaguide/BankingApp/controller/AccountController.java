package net.javaguide.BankingApp.controller;

import net.javaguide.BankingApp.dto.AccountDto;
import net.javaguide.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account Rest API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account Details Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit Rest Api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> amountDeposited(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.amountDeposited(id,amount);
        return ResponseEntity.ok(accountDto);

    }

    //Withdraw Rest Api
    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto =  accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);

    }

    // Get all accounts Rest Api
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account delete successfully");
    }

}
