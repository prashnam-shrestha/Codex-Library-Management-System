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
public class Library {
    private String libraryName;
    private int nextBookId = 10000;
    private int totalBooks;
    private int availableBooks;
    private int borrowedBooks;
    private int damangedBooks;
    private String passswordAdmin;
    
    // Storage for Books
    ArrayList<Book> inventory = new ArrayList<>();
    
    // Registered Users and Admins
    ArrayList<User> registeredUsers = new ArrayList<>();
    ArrayList<Admin> registeredAdmins = new ArrayList<>();
    
    // Constructor
    public Library(String name, String password) {
        
        setLibraryName(name);
        setPassswordAdmin(password);
    }
    
    // Add book
    public void addBook(Book book) {
        
        inventory.add(book);
        System.out.printf("\n✅ Successfully added book: '%s'\n", book.getTitleOfBook());
    }
    
    // Overloading add book
    public void addBook(Book book, int copies) {
        
        inventory.add(book);
        for (int i = 1; i < copies; i++) {
            Book bookCopy = new Book(book.getTitleOfBook(), book.getAuthorOfBook(),this );
            inventory.add(bookCopy);
        }
        System.out.printf("\n✅ Successfully added %s copies of the book: '%s'\n", copies, book.getTitleOfBook());
    }
    
    // Remove book
    public void removeBook(int ID) {
        for (Book b: inventory) {
            if (b.getIdOfBook() == ID) {
                inventory.remove(b);
                System.out.printf("\n✅ Successfully removed book '%s' (ID: %s)\n", b.getTitleOfBook(), b.getIdOfBook());
                return;
            }
        }
        System.out.printf("\n❌ Could not find book with ID %s\n", ID);
    }
    
    // Change status
    public void changeStatus(int ID, Status statusTo) {
        for (Book b: inventory) {
            if (b.getIdOfBook() == ID) {
                b.changeStatusOfBook(statusTo);
                System.out.printf("\n✅ Status of '%s' (ID: %s) updated to: %s\n", b.getTitleOfBook(), b.getIdOfBook(), statusTo);
                return;
            }
        }
        System.out.printf("\n❌ Could not find book with ID %s\n", ID);
    }
            
    //  Show all books
    public void showInventory() {
        
        this.setCountDetails();
        if (inventory.size() == 0) {
            System.out.println("\nℹ️ The library inventory is currently empty.");
            return;
        }
        
        System.out.println("\n  ===========================================================================================================");
        System.out.printf("                                          📦 Inventory of %-18s                          \n", getLibraryName());
        System.out.println("  ===========================================================================================================");
        
        
        for (Book book: inventory) {
            book.getInfoOfBook();
        }
        System.out.println("  -----------------------------------------------------------------------------------------------------------");
        System.out.printf("    📊 Total Books: %-4s │ ✅ Available: %-4s │ 📖 Borrowed: %-4s │ ⚠️ Damaged: %-4s \n", getBooksCountTotal(), getBooksCountAvailable(), getBooksCountBorrowed(), getDamangedBooks());
        System.out.println("  ===========================================================================================================\n");
    }
    
    // Search book
    public void searchBook(String key) {
        
        System.out.println("\n🔍 Searching Catalog...");
        boolean found = false;
        for (Book b: inventory) {
            if (key.toLowerCase().strip().equals(b.getTitleOfBook().toLowerCase().strip())) {
                b.getInfoOfBook();
                found = true;
            }
        }
        if (!found) {
            System.out.printf("❌ No books found matching the title: '%s'\n", key);
        }
    }
    
    // Add user
    public void addUser(User user) {
        registeredUsers.add(user);
    }
    
    // Add admin
    public void addAdmin(Admin admin) {
        registeredAdmins.add(admin);
    }
    
    // Get registered users and admins 
    public void showMemberInfo() {
        System.out.println("\n  ==========================================================");
        System.out.println("                     👥 Registered Users                     ");
        System.out.println("  ==========================================================");
        for (User u: registeredUsers) {
            u.getInfo();
        }
        System.out.println("\n  ==========================================================");
        System.out.println("                 🛡️ Registered Administrators                ");
        System.out.println("  ==========================================================");
        for (Admin a: registeredAdmins) {
            a.getInfo();
        }
        System.out.println("  ==========================================================\n");
    }
    
    // Check Out
    public void checkOutBook(int ID, User user) {
        for (Book b: inventory) {
            if ((b.getIdOfBook() == ID) && (b.getStatusOfBook() == Status.AVAILABLE)) {
                
                b.changeStatusOfBook(Status.BORROWED);
                user.addBookPocket(b);
                return;
            }
            else if ((b.getIdOfBook() == ID) && (b.getStatusOfBook() == Status.BORROWED)) {
                
                System.out.printf("\n❌ Sorry, the book '%s' (ID: %s) is currently borrowed.\n", b.getTitleOfBook(), b.getIdOfBook());
                return;
            }
            
            else if ((b.getIdOfBook() == ID) && (b.getStatusOfBook() == Status.DAMAGED)) {
                 System.out.printf("\n❌ Sorry, the book '%s' (ID: %s) is currently damaged.\n", b.getTitleOfBook(), b.getIdOfBook());
                 return;
            }
        }
        System.out.printf("\n❌ Book with ID %s not found in inventory.\n", ID);
    }
    
    // Check In
    
    public void checkInBook(int ID, User user) {
        for (Book b: user.userPocket) {
            if (b.getIdOfBook() == ID) {
                b.changeStatusOfBook(Status.AVAILABLE);
                user.removeBookPocket(b);
                return;
            }
        }
        System.out.printf("\n❌ Sorry, book with ID %s is not in your borrowed list!\n", ID);
    }
    
    // Update book
    public void updateBook(Book b, String newTitle, String newAuthor) {
                
        inventory.remove(b);
        Book book1 = new Book(newTitle, newAuthor, this);
        inventory.add(book1);
            
    }

    // Getters and setters
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getBooksCountTotal() {
        return totalBooks;
    }

    public int getBooksCountAvailable() {
        return availableBooks;
    }
    
    public void setCountDetails() {
        setAvailableBooks(0);
        setBorrowedBooks(0);
        setDamangedBooks(0);
        
        for (Book book: inventory) {
            
            if (book.getStatusOfBook() == Status.AVAILABLE) {
                this.availableBooks++;
            }
            else if (book.getStatusOfBook() == Status.BORROWED) {
                this.borrowedBooks++;
            }
            else {
                this.damangedBooks++;
            }
            
        }
        
        this.totalBooks = inventory.size();
    }
    
    public int getBooksCountBorrowed() {
        return borrowedBooks;
    }

    public int getNextBookIdGenerated() {
        return nextBookId;
    }

    public void setNextBookIdGenerated(int nextBookIdGenerated) {
        this.nextBookId = nextBookIdGenerated + 1;
    }

    public ArrayList<Book> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Book> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(ArrayList<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public ArrayList<Admin> getRegisteredAdmins() {
        return registeredAdmins;
    }

    public void setRegisteredAdmins(ArrayList<Admin> registeredAdmins) {
        this.registeredAdmins = registeredAdmins;
    }

    public int getDamangedBooks() {
        return damangedBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setDamangedBooks(int damangedBooks) {
        this.damangedBooks = damangedBooks;
    }

    public String getPassswordAdmin() {
        return passswordAdmin;
    }

    public void setPassswordAdmin(String passswordAdmin) {
        this.passswordAdmin = passswordAdmin;
    }
}