package com.example.bank_customer_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_customer_backend.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    
    List<Account> findByCustomer_CustomerId(Integer customerId);
}
