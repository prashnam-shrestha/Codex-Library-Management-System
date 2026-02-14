/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codex;

/**
 *
 * @author prashnamshrestha
 */
public class Admin extends Members{
    
    public Admin(String memberId, String memberPass) {
        super(memberId, memberPass);
    }
    
    public void getInfo() {
        System.out.println("  ┌────────────────────────────────────────────────────────┐");
        System.out.printf("  │ 🛡️ Admin ID: %-13s │ 🔑 Password: %-14s │\n",
                getMemberId(),
                getMemberPass()
        );
        System.out.println("  └────────────────────────────────────────────────────────┘");

    }
}