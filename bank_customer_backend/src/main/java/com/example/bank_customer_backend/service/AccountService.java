package com.example.bank_customer_backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_customer_backend.entity.Account;
import com.example.bank_customer_backend.entity.Customer;
import com.example.bank_customer_backend.repository.AccountRepository;
import com.example.bank_customer_backend.repository.CustomerRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public Account createAccount(Integer customerId, String accountType, BigDecimal initialBalance) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Account account = new Account();
            account.setCustomer(customer);
            account.setAccountType(accountType);
            account.setBalance(initialBalance);
            return accountRepository.save(account);
        }
        return null;
    }


    public List<Account> findAccountsByCustomerId(Integer customerId) {
        return accountRepository.findByCustomer_CustomerId(customerId);
    }


    public Account findAccountById(Integer accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }


    public Account updateBalance(Integer accountId, BigDecimal newBalance) {
        Account account = findAccountById(accountId);
        if (account != null) {
            account.setBalance(newBalance);
            return accountRepository.save(account);
        }
        return null;
    }
}
