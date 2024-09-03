package com.example.bank_customer_backend.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_customer_backend.entity.Transaction;
import com.example.bank_customer_backend.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/record")
    public ResponseEntity<Transaction> recordTransaction(@RequestParam Integer accountId, 
                                                         @RequestParam BigDecimal amount, 
                                                         @RequestParam String transactionType) {
        Transaction transaction = transactionService.recordTransaction(accountId, amount, transactionType);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.badRequest().build();
    }


    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable Integer accountId) {
        List<Transaction> transactions = transactionService.findTransactionsByAccountId(accountId);
        return ResponseEntity.ok(transactions);
    }


    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer transactionId) {
        Transaction transaction = transactionService.findTransactionById(transactionId);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }
}