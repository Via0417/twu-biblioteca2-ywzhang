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
        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        ba = new BibliotecaApp(books);
    }
    @Test
    public void test_successful_checkout(){
        boolean isSuccessful = ba.checkout(1);
        assertTrue(isSuccessful);
    }

    @Test
    public void test_unsuccessful_checkout(){
        ba.bookList.get(0).setChecked(true);
        boolean isSuccessful = ba.checkout(1);
        assertTrue(!isSuccessful);
    }

    @Test
    public void test_successful_return(){
        ba.bookList.get(0).setChecked(true);
        boolean isSuccessful = ba.returnBook(1);
        assertTrue(isSuccessful);
    }

    @Test
    public void test_unsuccessful_return(){
        boolean isSuccessful = ba.returnBook(1);
        assertTrue(!isSuccessful);
    }
}
