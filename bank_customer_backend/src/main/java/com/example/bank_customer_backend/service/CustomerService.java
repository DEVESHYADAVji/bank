package com.example.bank_customer_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_customer_backend.entity.Customer;
import com.example.bank_customer_backend.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public String deleteCustomer(Integer id){
        customerRepository.deleteById(id);
        return "Customer removed. "+id;
    }

    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setStatus(customer.getStatus());
        return customerRepository.save(existingCustomer);
    }
}
