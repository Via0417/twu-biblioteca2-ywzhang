package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    protected static List<Record> bookList;
    protected static List<Record> movieList;

    public BibliotecaApp(List<Record> books, List<Record> movies){
        bookList = books;
        movieList = movies;
    }

    public static void main(String[] args) {
        printWelcomePage();

        listInDetails(bookList, true);

        printMainMenu();

        Scanner  scanner = new Scanner(System.in);
        String option = scanner.next();
        printInvalidWarning(option);

        if (option.equals("2")){
            checkOut(scanner);
        }

        if (option.equals("3")){
            returnRecord(scanner);
        }
    }

    private static void returnRecord(Scanner scanner) {
        print("Please enter Id of the book you return: ");
        int bookId = Integer.valueOf(scanner.next());
        if(returnBook(bookId))
            printSuccessfulReturn();
        else
            printUnsuccessfulReturn();
    }

    private static void printUnsuccessfulReturn() {
        println("That is not a valid book to return.");
    }

    private static void printSuccessfulReturn() {
        println("Thank you for returning the book.");
    }

    private static void checkOut(Scanner scanner) {
        print("Please enter Id of the book you want: ");
        int bookId = Integer.valueOf(scanner.next());
        if(isCheckout(bookId))
            printSuccessfulCheckout();
        else
            printUnsuccessfulCheckout();
    }

    private static void printUnsuccessfulCheckout() {
        println("That book is not available.");
    }

    private static void printSuccessfulCheckout() {
        println("Thank you! Enjoy the book.");
    }

    private static void printInvalidWarning(String option) {
        if (!(option.equals("1")||option.equals("2")||option.equals("3")))
            println("Select a valid option!");
    }

    private static void printMainMenu() {
        System.out.println("Please select the option number that you want:\n" +
                "1. Book list\n" +
                "2. Checkout book\n" +
                "3. Return book\n" +
                "4. Quit");
    }

    private static void listInDetails(List<Record> records, boolean isBook) {
        println("Id\tTitle\tAuthor\tYear");
        for (Record record : records){
            if(!record.isCheck()){
                println(record.getId() + "\t" + record.getTitle() + "\t"
                        + record.getAuthorOrDirector() + "\t" + record.getYear());
            }
        }
    }

    private static void printWelcomePage() {
        System.out.println("Welcome to Bangalore Public Library!");
    }

    public static boolean isCheckout(int id){
        boolean isSuccessful = false;
        for (Record book : bookList){
            if (book.getId() == id){
                if (book.isCheck() == false){
                    book.setCheck(true);
                    isSuccessful = true;
                }
                break;
            }
        }
        return isSuccessful;
    }

    public static boolean returnBook(int id){
        boolean isSuccessful = false;
        for (Record book : bookList){
            if (book.getId() == id){
                if (book.isCheck() == true){
                    book.setCheck(false);
                    isSuccessful = true;
                }
                break;
            }
        }
        return isSuccessful;
    }

    public static void println(String content){
        System.out.println(content);
    }

    public static void print(String content){
        System.out.print(content);
    }
}
