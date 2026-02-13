/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codex;

/**
 *
 * @author prashnamshrestha
 */
public class Admin {
    private String adminId;
    private String password;
    
    public Admin(String adminId, String password) {
        setAdminId(adminId);
        setPassword(password);
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void getInfo() {
        System.out.println("  ┌────────────────────────────────────────────────────────┐");
        System.out.printf("  │ 🛡️ Admin ID: %-13s │ 🔑 Password: %-14s │\n", getAdminId(), getPassword());
        System.out.println("  └────────────────────────────────────────────────────────┘");
    }
}