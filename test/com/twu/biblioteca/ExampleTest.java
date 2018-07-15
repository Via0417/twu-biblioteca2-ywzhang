package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExampleTest {

    private BibliotecaApp ba;

    @Before
    public void setup(){
        Book book1 = new Book(1, "A", "Annie", "2001");
        Book book2 = new Book(2, "B", "Bill", "2018");
        Book book3 = new Book(3, "C", "Cindy", "2010");
        List<Record> books = new ArrayList<Record>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Movie m1 = new Movie(1, "MA", "Anna", "2001");
        Movie m2 = new Movie(2, "MB", "Bob", "2017");
        Movie m3 = new Movie(3, "MC", "Carol", "2011");
        List<Record> movies = new ArrayList<Record>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);

        ba = new BibliotecaApp(books, movies);
    }
    @Test
    public void test_successful_checkout(){
        boolean isSuccessful = ba.isCheckout(1);
        assertTrue(isSuccessful);
    }

    @Test
    public void test_unsuccessful_checkout(){
        ba.bookList.get(0).setCheck(true);
        boolean isSuccessful = ba.isCheckout(1);
        assertTrue(!isSuccessful);
    }

    @Test
    public void test_successful_return(){
        ba.bookList.get(0).setCheck(true);
        boolean isSuccessful = ba.returnBook(1);
        assertTrue(isSuccessful);
    }

    @Test
    public void test_unsuccessful_return(){
        boolean isSuccessful = ba.returnBook(1);
        assertTrue(!isSuccessful);
    }
}
