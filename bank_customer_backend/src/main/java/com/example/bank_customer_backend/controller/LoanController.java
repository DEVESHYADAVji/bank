package com.example.bank_customer_backend.controller;

import com.example.bank_customer_backend.entity.Loan;
import com.example.bank_customer_backend.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public Loan applyForLoan(@RequestBody Loan loan) {
        return loanService.applyForLoan(loan);
    }

    @PutMapping("/update-status/{loanId}")
    public Loan updateLoanStatus(@PathVariable Integer loanId, @RequestParam String status) {
        return loanService.updateLoanStatus(loanId, status);
    }

    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable Integer loanId) {
        return loanService.getLoanById(loanId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Loan> getLoansByCustomerId(@PathVariable Integer customerId) {
        return loanService.getLoansByCustomerId(customerId);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}
