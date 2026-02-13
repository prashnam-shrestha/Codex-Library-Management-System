/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.codex;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class Codex {

    public static void main(String[] args) {
        // Main file to run program
        
        // new Library by default
        Library lib = new Library("Prashnam library", "demoPassword1234");
        
        Scanner sc = new Scanner(System.in);
        
        boolean exit = false;
        do {
            
            printMenuMain(lib);
            System.out.print("\n👉 Enter your choice: ");
            int choiceMainMenu = sc.nextInt();
            sc.nextLine();
            
            switch(choiceMainMenu) {
                // Login
                case 1:

                    System.out.print("\n👤 Enter Username: ");
                    String loginId = sc.nextLine();

                    System.out.print("🔑 Enter Password: ");
                    String loginPassword = sc.nextLine();
                    
                    loginUser(lib, loginId, loginPassword);
 
                    break;
                    
                // Register
                case 2:
                    printMenuRegister();
                    System.out.print("\n👉 Enter your choice: ");
                    int choiceRegisterMain = sc.nextInt();
                    
                    if (choiceRegisterMain == 1) {
                        registerNewUser(lib);
                    }
                    else if(choiceRegisterMain == 2) {
                        registerNewAdmin(lib);
                    }
                                        
                    break;
                    
                case 3:
                    exit = true;
                    System.out.println("\n✅ Exiting Codex System. Have a great day! 👋\n");
                    break;
                    
                default:
                    System.out.printf("\n❌ Invalid Option: %s. Please try again.\n", choiceMainMenu);
            
            }
                
        } while(!exit);
        
         sc.close();
            
    }

    // Other functions
    public static void printMenuMain(Library lib) {
        System.out.println("\n=======================================================");
        System.out.printf("              🏛️ Welcome to %s              \n", lib.getLibraryName());
        System.out.println("=======================================================");
        System.out.println("  1️⃣ Login");
        System.out.println("  2️⃣ Register");
        System.out.println("  3️⃣ Exit");
        System.out.println("-------------------------------------------------------");
    }
    
    public static void printMenuRegister() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("                  📝 Account Registration              ");
        System.out.println("-------------------------------------------------------");
        System.out.println("  1️⃣ Register as User");
        System.out.println("  2️⃣ Register as Administrator");
        System.out.println("-------------------------------------------------------");
    }
    
    public static void printMenuUser(User user) {
        System.out.println("\n=======================================================");
        System.out.printf("               👋 Welcome, Member: %-18s \n", user.getUserId());
        System.out.println("=======================================================");
        System.out.println("     [1] Search Book Catalog");
        System.out.println("     [2] Borrow a Book");
        System.out.println("     [3] Return a Book");
        System.out.println("     [4] View My Profile & Borrowed Books");
        System.out.println("     [5] Logout");
        System.out.println("-------------------------------------------------------");
    }
    
    public static void printMenuAdmin(Admin admin) {
        System.out.println("\n=======================================================");
        System.out.printf("            🛠️ Welcome, Administrator: %-13s \n", admin.getAdminId());
        System.out.println("=======================================================");
        System.out.println("     [1] Add New Book");
        System.out.println("     [2] Remove Book");
        System.out.println("     [3] Update Book");
        System.out.println("     [4] View Full Inventory");
        System.out.println("     [5] Member Directory");      
        System.out.println("     [6] Logout");
        System.out.println("-------------------------------------------------------");
    }
    
    public static void registerNewAdmin(Library lib) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\n🔐 Enter Master Library Password: ");
        String password = sc.nextLine();
        if (password.equals(lib.getPassswordAdmin())) {

            System.out.println("\n✅ Master Password Accepted.");
            System.out.print("🛡️ Enter new Admin Username: ");
            String newAdminId = sc.nextLine();

            System.out.print("🔑 Enter new Admin Password: ");
            String newAdminPassword = sc.nextLine();

            Admin admin1 = new Admin(newAdminId, newAdminPassword);
            lib.addAdmin(admin1);

            System.out.printf("\n✅ Administrator Account Created Successfully!\n    Username : %s \n    Password : %s \n", newAdminId, newAdminPassword);

        }
        else {
            System.out.println("\n❌ Incorrect master password. Administrator creation failed.");
        }
    }
    
    public static void registerNewUser(Library lib) {
            Scanner sc = new Scanner(System.in);

            System.out.print("\n👤 Enter new User Username: ");
            String newUserId = sc.nextLine();

            System.out.print("🔑 Enter new User Password: ");
            String newUserPassword = sc.nextLine();

            User user1 = new User(newUserId, newUserPassword);
            lib.addUser(user1);

            System.out.printf("\n✅ User Account Created Successfully!\n    Username : %s \n    Password : %s \n", newUserId, newUserPassword);
    }
    
    public static void loginUser(Library lib, String loginId, String loginPassword) {
        
        ArrayList<Admin> registeredAdmins = lib.getRegisteredAdmins();
        ArrayList<User> registeredUsers = lib.getRegisteredUsers();
        
        // Checking admin
        for (Admin a: registeredAdmins) {
            if (a.getAdminId().equals(loginId) && a.getPassword().equals(loginPassword)) {
                
                boolean logOut = false;
                while (!logOut) {
                    
                    logOut = adminHomePage(a, lib);
                    
                }
                return;
            }
        }
        
        for (User u: registeredUsers) {
            if (u.getUserId().equals(loginId) && u.getPassword().equals(loginPassword)) {
                
                boolean logOut = false;
                while (!logOut) {
                    
                    logOut = userHomePage(u, lib);
                    
                }
                return;
            }
        }
        System.out.println("\n❌ Invalid Username or Password. Please try again.");

    }
    
    public static boolean adminHomePage(Admin admin1, Library lib) {
        Scanner sc = new Scanner(System.in);
        
        printMenuAdmin(admin1);
        System.out.print("\n👉 Enter your choice: ");
        int choiceAdminHomePage = sc.nextInt();
        sc.nextLine();
        
        switch(choiceAdminHomePage) {
            
            // Add book
            case 1:
                System.out.print("\n🏷️ Enter Book Title: ");
                String bookName = sc.nextLine();
                
                System.out.print("✍️ Enter Author Name: ");
                String authorName = sc.nextLine();
                
                System.out.print("🔢 Enter Number of Copies: ");
                int howMany = sc.nextInt();
                sc.nextLine();
                
                Book bookNew = new Book(bookName, authorName, lib);
                
                lib.addBook(bookNew, howMany);
                
                break;
            
            // Remove book
            case 2:
                    System.out.printf("\n🆔 Enter Book ID to remove: ");
                    int bookIdDelete = sc.nextInt();
                    sc.nextLine();
                    boolean notFound = true;
                    
                    for (Book b: lib.inventory) {
                        if ((b.getIdOfBook() == bookIdDelete) && (b.getStatusOfBook() == Status.BORROWED)) {
                            System.out.println("\n❌ Cannot remove a book that is currently checked out!");
                            notFound = false;
                            break;
                        }
                       
                        else if ((b.getIdOfBook() == bookIdDelete) && ( b.getStatusOfBook() != Status.BORROWED)) {
                            lib.removeBook(bookIdDelete);
                            notFound = false;
                            break;
                        }
                    }
                    if (notFound) {
                        System.out.printf("\n❌ Book with ID %s not found in inventory!\n", bookIdDelete);
                    }
                    break;
            
            // Update
            case 3:
                System.out.printf("\n🆔 Enter Book ID to update: ");
                int bookIdUpdate = sc.nextInt();
                sc.nextLine();
                boolean notFound3 = true;
                
                for (Book b: lib.inventory) {
                    if ((b.getIdOfBook() == bookIdUpdate) && (b.getStatusOfBook() != Status.BORROWED)) {
                        
                        System.out.printf("\n🏷️ Enter new Book title: ");
                        String newTitle = sc.nextLine();
                        System.out.printf("✍️ Enter new Author Name: ");
                        String newAuthor = sc.nextLine();
                        notFound3 = false;
                        lib.updateBook(b, newTitle, newAuthor); 
                        break;
                    }
                    if ((b.getIdOfBook() == bookIdUpdate) && (b.getStatusOfBook() == Status.BORROWED)) {
                        System.out.println("\n❌ Cannot update a book that is currently checked out!");
                        break;
                    }
                }
                if (notFound3) {
                    System.out.printf("\n❌ Book with ID %s not found in inventory!\n", bookIdUpdate);
                }
                
                break;
            
            // Show inventory and member details
            case 4:
                lib.showInventory();
                break;
                
            case 5:
                lib.showMemberInfo();
                break;
                
            // Log out
            case 6:
                return true;
                
            default:
                System.out.printf("\n❌ Invalid Option: %s. Please try again.\n", choiceAdminHomePage);
             
        }
        // No logout if !case5;
        return false;
              
    }
    
    public static boolean userHomePage(User u, Library lib) {
        Scanner sc = new Scanner(System.in);
        
        printMenuUser(u);
        System.out.print("\n👉 Enter your choice: ");
        int choiceUserHomePage = sc.nextInt();
        sc.nextLine();
        
        switch(choiceUserHomePage) {
            
            // Search book in library
            case 1:
                System.out.print("\n🔍 Enter Book Title to search: ");
                String searchTitle = sc.nextLine();
                
                lib.searchBook(searchTitle);
                break;
                
            // Check out;
            case 2:
                System.out.print("\n📖 Enter Book ID to borrow: ");
                int borrowId = sc.nextInt();
                sc.nextLine();
                
                lib.checkOutBook(borrowId, u);
                break;
            
            // Return book
            case 3:
                System.out.print("\n↩️ Enter Book ID to return: ");
                int returnId = sc.nextInt();
                sc.nextLine();
                
                lib.checkInBook(returnId, u);
                break;
             
            // Show details
            case 4:
                u.getInfo();
                break;
            
            // Log out;
            case 5:
                return true;
            
            default:
                System.out.printf("\n❌ Invalid Option: %s. Please try again.\n", choiceUserHomePage);     
                
        }
        // No logout if !case5;
        return false; 
    }
}
