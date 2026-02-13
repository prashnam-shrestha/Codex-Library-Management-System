/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codex;

/**
 *
 * @author prashnamshrestha
 */
public class Book {
  
    private String titleOfBook;
    private String authorOfBook;
    private int idOfBook;
    private Status statusOfBook = Status.AVAILABLE;
    
    // Constructor
    public Book(String title, String author, Library lib) {
        
        setTitleOfBook(title);
        setAuthorOfBook(author);
        setIdOfBook(lib);
    }
    // Methods
    public void getInfoOfBook() {
        System.out.println("  ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.printf("  │ ID: %-7s │ Status: %-10s │ Author: %-20s │ Title: %-30s │\n", getIdOfBook(), getStatusOfBook() , getAuthorOfBook(), getTitleOfBook());
        System.out.println("  └─────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }

    // Getters and Setters
    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public Status getStatusOfBook() {
        return statusOfBook;
    }

    // Change status of the book
    public void changeStatusOfBook(Status changeStatusTo) {
        this.statusOfBook = changeStatusTo;
    }

    public int getIdOfBook() {
        return idOfBook;
    }

    public void setIdOfBook(Library lib) {
        lib.setNextBookIdGenerated(lib.getNextBookIdGenerated());
        this.idOfBook = lib.getNextBookIdGenerated();
    }
    
    
    
    
    
    
}