package com.example.bank_admin_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_admin_backend.entity.Admin;
import com.example.bank_admin_backend.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    public String deleteAdmin(Integer id){
        adminRepository.deleteById(id);
        return "Admin removed. "+id;
    }

    public Admin updateAdmin(Admin admin){
        Admin existingAdmin = adminRepository.findById(admin.getAdminId()).orElse(null);
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setRole(admin.getRole());
        return adminRepository.save(existingAdmin);
    }
}