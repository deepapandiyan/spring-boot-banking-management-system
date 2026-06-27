package com.example.Banking_Management_system.service;

import com.example.Banking_Management_system.dto.AccountDto;
import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto updateAccount(Long id, AccountDto accountDto);

    void deleteAccount(Long id);

    List<AccountDto> getAllAccounts();
}