package com.example.bank_admin_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_admin_backend.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
