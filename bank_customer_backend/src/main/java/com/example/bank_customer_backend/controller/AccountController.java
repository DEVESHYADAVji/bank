package com.example.bank_customer_backend.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_customer_backend.entity.Account;

import com.example.bank_customer_backend.service.AccountService;



@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestParam Integer customerId, 
                                                 @RequestParam String accountType, 
                                                 @RequestParam BigDecimal initialBalance) {
        Account account = accountService.createAccount(customerId, accountType, initialBalance);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.badRequest().build();
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable Integer customerId) {
        List<Account> accounts = accountService.findAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer accountId) {
        Account account = accountService.findAccountById(accountId);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }


    @PutMapping("/{accountId}/balance")
    public ResponseEntity<Account> updateBalance(@PathVariable Integer accountId, 
                                                 @RequestParam BigDecimal newBalance) {
        Account updatedAccount = accountService.updateBalance(accountId, newBalance);
        return updatedAccount != null ? ResponseEntity.ok(updatedAccount) : ResponseEntity.notFound().build();
    }
}