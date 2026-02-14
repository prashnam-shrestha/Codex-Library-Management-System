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
public class User extends Members{
    
    public User(String memberId, String memberPass) {
        super(memberId, memberPass);
    }

    private ArrayList<Book> userPocket = new ArrayList<>();
    
    // Add book in the pocket
    public void addBookPocket(Book book) {
        userPocket.add(book);
        System.out.printf("\n✅ Successfully borrowed '%s'. Assigned to user: 👤 %s\n", book.getTitleOfBook(), getMemberId());
    }
    
    // Remove book in the pocket
    public void removeBookPocket(Book book) {
        userPocket.remove(book);
         System.out.printf("\n✅ Successfully returned '%s'. Unassigned from user: 👤 %s\n", book.getTitleOfBook(), getMemberId());
    }
    
    public void getInfo() {
        System.out.println("  ┌────────────────────────────────────────────────────────┐");
        System.out.printf("  │ 👤 User ID: %-14s │ 🔑 Password: %-14s │\n", getMemberId(), getMemberPass());
        System.out.println("  └────────────────────────────────────────────────────────┘");
        
        if (userPocket.size() == 0) {
            System.out.printf("    ℹ️ %s has no currently borrowed books.\n", getMemberId());
            return;
        }
        
        System.out.printf("    📚 %s has borrowed the following books:\n", getMemberId());
        
        for (Book b: userPocket) {
            b.getInfoOfBook();
        }
    }

    public ArrayList<Book> getUserPocket() {
        return userPocket;
    }

    public void setUserPocket(ArrayList<Book> userPocket) {
        this.userPocket = userPocket;
    }
    
    
}