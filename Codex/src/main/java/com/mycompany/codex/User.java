/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codex;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class User {
    private String userId;
    private String password;
    
    public User(String userId, String password) {
        setUserId(userId);
        setPassword(password);
    }

    ArrayList<Book> userPocket = new ArrayList<>();
    
    // Add book in the pocket
    public void addBookPocket(Book book) {
        userPocket.add(book);
        System.out.printf("\n✅ Successfully borrowed '%s'. Assigned to user: 👤 %s\n", book.getTitleOfBook(), getUserId());
    }
    
    // Remove book in the pocket
    public void removeBookPocket(Book book) {
        userPocket.remove(book);
         System.out.printf("\n✅ Successfully returned '%s'. Unassigned from user: 👤 %s\n", book.getTitleOfBook(), getUserId());
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void getInfo() {
        System.out.println("  ┌────────────────────────────────────────────────────────┐");
        System.out.printf("  │ 👤 User ID: %-14s │ 🔑 Password: %-14s │\n", getUserId(), getPassword());
        System.out.println("  └────────────────────────────────────────────────────────┘");
        
        if (userPocket.size() == 0) {
            System.out.printf("    ℹ️ %s has no currently borrowed books.\n", getUserId());
            return;
        }
        
        System.out.printf("    📚 %s has borrowed the following books:\n", getUserId());
        
        for (Book b: userPocket) {
            b.getInfoOfBook();
        }
    }
}