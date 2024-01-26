package com.example.student_management_portal.services;

public interface IAuthenticationServices {
    public void createAdmin(String email, String password);
    public boolean getAdmin(String email, String password);
}
