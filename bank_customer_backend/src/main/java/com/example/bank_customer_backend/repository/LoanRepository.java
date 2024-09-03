package com.example.bank_customer_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_customer_backend.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findByCustomerCustomerId(Integer customerId);

}
