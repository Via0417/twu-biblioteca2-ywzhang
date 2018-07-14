package com.twu.biblioteca;

public class Book {
    private int id;
    private String name;
    private String author;
    private String year;
    private boolean isChecked;

    public Book(int id, String name, String author, String year){
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        isChecked = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

