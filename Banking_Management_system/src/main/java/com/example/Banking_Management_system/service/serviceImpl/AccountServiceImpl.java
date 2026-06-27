package com.example.Banking_Management_system.service.serviceImpl;

import com.example.Banking_Management_system.dto.AccountDto;
import com.example.Banking_Management_system.entity.Account;
import com.example.Banking_Management_system.mapper.AccountMapper;
import com.example.Banking_Management_system.repository.AccountRepository;
import com.example.Banking_Management_system.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapAccountDtoToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapAccountToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.mapAccountToAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setAccountName(accountDto.getAccountName());
        account.setBalance(accountDto.getBalance());

        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapAccountToAccountDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        accountRepository.delete(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream()
                .map(AccountMapper::mapAccountToAccountDto)
                .collect(Collectors.toList());
    }
}