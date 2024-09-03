package com.example.bank_admin_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_admin_backend.entity.LoanRequest;

public interface LoanRequestRepository extends JpaRepository<LoanRequest, Integer>{
    
    List<LoanRequest> findByCustomerId(Integer customerId);
}
