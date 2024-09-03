package com.example.bank_admin_backend.controller;

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

import com.example.bank_admin_backend.entity.LoanRequest;
import com.example.bank_admin_backend.service.LoanRequestService;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {
    @Autowired
    private LoanRequestService loanRequestService;


    @PostMapping("/submit")
    public ResponseEntity<LoanRequest> submitLoanRequest(@RequestParam Integer customerId, 
                                                         @RequestParam BigDecimal loanAmount, 
                                                         @RequestParam BigDecimal interestRate, 
                                                         @RequestParam Integer loanTerm) {
        LoanRequest loanRequest = loanRequestService.submitLoanRequest(customerId, loanAmount, interestRate, loanTerm);
        return loanRequest != null ? ResponseEntity.ok(loanRequest) : ResponseEntity.badRequest().build();
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<LoanRequest>> getLoanRequestsByCustomerId(@PathVariable Integer customerId) {
        List<LoanRequest> loanRequests = loanRequestService.findLoanRequestsByCustomerId(customerId);
        return ResponseEntity.ok(loanRequests);
    }


    @GetMapping("/{requestId}")
    public ResponseEntity<LoanRequest> getLoanRequestById(@PathVariable Integer requestId) {
        LoanRequest loanRequest = loanRequestService.findLoanRequestById(requestId);
        return loanRequest != null ? ResponseEntity.ok(loanRequest) : ResponseEntity.notFound().build();
    }


    @PutMapping("/{requestId}/status")
    public ResponseEntity<LoanRequest> updateLoanRequestStatus(@PathVariable Integer requestId, 
                                                               @RequestParam String status) {
        LoanRequest updatedLoanRequest = loanRequestService.updateLoanRequestStatus(requestId, status);
        return updatedLoanRequest != null ? ResponseEntity.ok(updatedLoanRequest) : ResponseEntity.notFound().build();
    }
}
