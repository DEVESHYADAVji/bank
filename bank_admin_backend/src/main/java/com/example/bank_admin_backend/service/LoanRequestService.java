package com.example.bank_admin_backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_admin_backend.entity.LoanRequest;
import com.example.bank_admin_backend.repository.LoanRequestRepository;

@Service
public class LoanRequestService {
     @Autowired
    private LoanRequestRepository loanRequestRepository;


    public LoanRequest submitLoanRequest(Integer customerId, BigDecimal loanAmount, BigDecimal interestRate, Integer loanTerm) {
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setCustomerId(customerId);
        loanRequest.setLoanAmount(loanAmount);
        loanRequest.setInterestRate(interestRate);
        loanRequest.setLoanTerm(loanTerm);
        loanRequest.setStatus("PENDING");
        return loanRequestRepository.save(loanRequest);
    }


    public List<LoanRequest> findLoanRequestsByCustomerId(Integer customerId) {
        return loanRequestRepository.findByCustomerId(customerId);
    }


    public LoanRequest findLoanRequestById(Integer requestId) {
        return loanRequestRepository.findById(requestId).orElse(null);
    }


    public LoanRequest updateLoanRequestStatus(Integer requestId, String status) {
        Optional<LoanRequest> loanRequestOptional = loanRequestRepository.findById(requestId);
        if (loanRequestOptional.isPresent()) {
            LoanRequest loanRequest = loanRequestOptional.get();
            loanRequest.setStatus(status);
            return loanRequestRepository.save(loanRequest);
        }
        return null;
    }
}