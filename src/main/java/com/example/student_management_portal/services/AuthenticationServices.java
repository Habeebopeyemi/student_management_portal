package com.example.student_management_portal.services;

import com.example.student_management_portal.entities.Admin;
import com.example.student_management_portal.repositories.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServices implements IAuthenticationServices{
    @Autowired
    public IAdminRepository adminRepository;
    @Override
    public void createAdmin(String email, String password) {
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        adminRepository.save(admin);
    }

    @Override
    public boolean getAdmin(String email, String password) {
        boolean success = true;
        String retrievedPassword = "";
        String retrievedEmail = "";
        Optional<Admin> admin =  adminRepository.findByEmail(email);
        if(admin.isPresent()){
            Admin testAdmin = admin.get();
            retrievedPassword = testAdmin.getPassword();
            success = retrievedPassword.equals(password);
        }else{
            success = false;
        }
        return success;
    }
}
