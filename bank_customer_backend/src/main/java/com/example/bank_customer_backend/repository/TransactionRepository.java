package com.example.bank_customer_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_customer_backend.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    
    List<Transaction> findByAccount_AccountId(Integer accountId);
}
