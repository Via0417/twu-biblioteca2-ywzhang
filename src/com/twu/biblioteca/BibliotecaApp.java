package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    protected static List<Book> bookList;

    public BibliotecaApp(List<Book> books){
        bookList = books;
    }

    public static void main(String[] args) {
        //Welcome page
        println("Welcome to Bangalore Public Library!");

        /*
        //list books
        println("Id\tBook");
        for (Book book : bookList){
            println(book.getId() + "\t" + book.getName());
        }
        */

        //list book in details
        println("Id\tBook\tAuthor\tYear");
        for (Book book : bookList){
            if(!book.isChecked()){
                println(book.getId() + "\t" + book.getName() + "\t"
                        + book.getAuthor() + "\t" + book.getYear());
            }
        }

        //Main menu
        println("Please select the option number that you want:\n" +
                "1. Book list\n" +
                "2. Checkout book\n" +
                "3. Return book\n" +
                "4. Quit");

        Scanner  scanner = new Scanner(System.in);
        String option = scanner.next();

        //Invalid Menu Option
        if (!(option.equals("1")||option.equals("2")||option.equals("3")))
            println("Select a valid option!");

        //Checkout Book
        if (option.equals("2")){
            print("Please enter Id of the book you want: ");
            int bookId = Integer.valueOf(scanner.next());
            if(checkout(bookId))
                //Successful Checkout
                println("Thank you! Enjoy the book.");
            else
                //Unsuccessful Checkout
                println("That book is not available.");
        }

        //Return Book
        if (option.equals("3")){
            print("Please enter Id of the book you return: ");
            int bookId = Integer.valueOf(scanner.next());
            if(returnBook(bookId))
                //Successful Return
                println("Thank you for returning the book.");
            else
                //Unsuccessful Return
                println("That is not a valid book to return.");
        }


        //Quit
        if (option.equals("4"))
            ;

    }

    public static boolean checkout(int bookId){
        boolean isSuccessful = false;
        for (Book book : bookList){
            if (book.getId() == bookId){
                if (book.isChecked() == false){
                    book.setChecked(true);
                    isSuccessful = true;
                }
                break;
            }
        }
        return isSuccessful;
    }

    public static boolean returnBook(int bookId){
        boolean isSuccessful = false;
        for (Book book : bookList){
            if (book.getId() == bookId){
                if (book.isChecked() == true){
                    book.setChecked(false);
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
