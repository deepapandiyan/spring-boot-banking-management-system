package com.example.Banking_Management_system.repository;

import com.example.Banking_Management_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
