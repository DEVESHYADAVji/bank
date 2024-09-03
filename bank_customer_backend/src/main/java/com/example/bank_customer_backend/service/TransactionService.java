package com.example.bank_customer_backend.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_customer_backend.entity.Account;
import com.example.bank_customer_backend.entity.Transaction;
import com.example.bank_customer_backend.repository.AccountRepository;
import com.example.bank_customer_backend.repository.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Record a new transaction
    public Transaction recordTransaction(Integer accountId, BigDecimal amount, String transactionType) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            Transaction transaction = new Transaction();
            transaction.setAccount(account);
            transaction.setAmount(amount);
            transaction.setTransactionType(transactionType);
            transaction.setTransactionDate(LocalDateTime.now());
            return transactionRepository.save(transaction);
        }
        return null; // Or throw a custom exception if account not found
    }

    // Retrieve transactions by account ID
    public List<Transaction> findTransactionsByAccountId(Integer accountId) {
        return transactionRepository.findByAccount_AccountId(accountId);
    }

    // Retrieve a transaction by its ID
    public Transaction findTransactionById(Integer transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }
}
