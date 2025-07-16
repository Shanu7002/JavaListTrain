/*
 * Basic library system with a Book class.
 * Each book has a title, author, and loan status.
 * Includes methods to add, lend, return, and list available books.
 * Useful for learning object behavior and boolean flags.
 */
package Project3;

public class Book {
    private String title;
    private String author;
    private Boolean loan;

    public Book(String title, String author, Boolean loan) {
        this.title = title;
        this.author = author;
        this.loan = loan;
    }
    public Book(){}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Boolean getLoan() {
        return loan;
    }
    public void setLoan(Boolean loan) {
        this.loan = loan;
    }
    public String toString(){
        return "Author: " + author + "\nTitle: " + title + "\nLoan available? " + loan;
    }
}
