package com.example.bank_admin_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_admin_backend.entity.Admin;
import com.example.bank_admin_backend.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Integer id) {
        return adminService.getAdminById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Integer id){
        return adminService.deleteAdmin(id);
    }

    @PutMapping("/update")
    public Admin updateCustomer(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }
}