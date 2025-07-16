/*
 * Basic library system with a Book class.
 * Each book has a title, author, and loan status.
 * Includes methods to add, lend, return, and list available books.
 * Useful for learning object behavior and boolean flags.
 */
package Project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Book> newBook = new ArrayList<>();
        System.out.print("Do you want to add a book? (y/n)");
        String moreBooksString = sc.nextLine();
        boolean moreBooks;
        moreBooks = moreBooksVerify(moreBooksString);
        // Loop to add books to the list
        while(moreBooks){
          System.out.print("Enter Book Name: ");
          String bookName = sc.nextLine();
          System.out.print("Enter Book Author: ");
          String bookAuthor = sc.nextLine();
          System.out.print("Is book available to loan? (y/n)");
          String bookAvailableString = sc.nextLine();
          boolean bookAvailable;
            if(bookAvailableString.equalsIgnoreCase("y")){
                bookAvailable = true;
            } else{
                bookAvailable = false;
            }
            // Add the new book to the list
            newBook.add(new Book(bookName, bookAuthor, bookAvailable));
          System.out.print("Do you want to add another book? (y/n) ");
          String addBook = sc.nextLine();
          if(addBook.equals("y")){
              moreBooks = true;
          }else{
              moreBooks = false;
          }
        }
        // Ask if the user wants to loan a book
        System.out.print("Do you want to loan a book? (y/n)");
        moreBooksString = sc.nextLine();
        moreBooks = moreBooksVerify(moreBooksString);
        while(moreBooks){
            System.out.println("This is the available books: ");
            printAvailableBooks(newBook);
            System.out.print("Which book do you want to loan? ");
            String loanBook = sc.nextLine();
            Integer loanBookInteger = findBookIndex(newBook, loanBook);
            if (loanBookInteger != null) {
                newBook.get(loanBookInteger).setLoan(false);
                System.out.println("Book loaned successfully.");
            } else {
                System.out.println("Book not found.");
            }
            System.out.print("Do you want to loan another book? (y/n)");
            moreBooksString = sc.nextLine();
            moreBooks = moreBooksVerify(moreBooksString);
            System.out.println("This is the available books: ");
            printAvailableBooks(newBook);
        }

        System.out.println("Thank you for everything, good read for you!");



        sc.close();
    }
    // Helper method to check if the user answered 'yes'
    public static boolean moreBooksVerify(String moreBooksString){
        if(moreBooksString.equalsIgnoreCase("y")){
            return true;
        } else {
            return false;
        }
    }
    // Find a book in the list by its title (case-insensitive)
    public static Integer findBookIndex(List<Book> list, String loanBook){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getTitle().equalsIgnoreCase(loanBook)){
                return i;
            }
        }
        return null;
    }
    // Print all books that are available for loan
    public static void printAvailableBooks(List<Book> books){
        System.out.println("Available Books: ");
        for(Book book : books){
            if (book.getLoan()){
                System.out.println(book);
                System.out.println("--------------");
            }
        }
    }
}
