package com.example.bank_customer_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_customer_backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

    Customer findCustomerByEmail(String email);
    
}
