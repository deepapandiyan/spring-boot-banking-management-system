package com.example.Banking_Management_system.controller;

import com.example.Banking_Management_system.dto.AccountDto;
import com.example.Banking_Management_system.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {

        AccountDto savedAccount = accountService.createAccount(accountDto);

        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {

        AccountDto accountDto = accountService.getAccountById(id);

        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(
            @PathVariable Long id,
            @RequestBody AccountDto accountDto) {

        AccountDto updatedAccount = accountService.updateAccount(id, accountDto);

        return ResponseEntity.ok(updatedAccount);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {

        accountService.deleteAccount(id);

        return ResponseEntity.ok("Account deleted successfully");
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {

        List<AccountDto> accounts = accountService.getAllAccounts();

        return ResponseEntity.ok(accounts);
    }
}