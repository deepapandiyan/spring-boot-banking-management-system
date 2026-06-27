package com.example.Banking_Management_system.mapper;

import com.example.Banking_Management_system.dto.AccountDto;
import com.example.Banking_Management_system.entity.Account;

public class AccountMapper {

    public static Account mapAccountDtoToAccount(AccountDto accountDto) {

        return new Account(
                accountDto.getId(),
                accountDto.getAccountName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapAccountToAccountDto(Account account) {

        return new AccountDto(
                account.getId(),
                account.getAccountName(),
                account.getBalance()
        );
    }
}