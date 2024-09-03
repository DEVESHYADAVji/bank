package com.example.bank_customer_backend.service;

import com.example.bank_customer_backend.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan applyForLoan(Loan loan);
    Loan updateLoanStatus(Integer loanId, String status);
    Loan getLoanById(Integer loanId);
    List<Loan> getLoansByCustomerId(Integer customerId);
    List<Loan> getAllLoans();
}
