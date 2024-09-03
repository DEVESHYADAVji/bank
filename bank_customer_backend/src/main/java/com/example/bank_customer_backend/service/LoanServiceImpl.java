package com.example.bank_customer_backend.service;

import com.example.bank_customer_backend.entity.Loan;
import com.example.bank_customer_backend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan applyForLoan(Loan loan) {
        loan.setStatus("PENDING");
        return loanRepository.save(loan);
    }

    @Override
    public Loan updateLoanStatus(Integer loanId, String status) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setStatus(status);
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Integer loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    @Override
    public List<Loan> getLoansByCustomerId(Integer customerId) {
        return loanRepository.findByCustomerCustomerId(customerId);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
