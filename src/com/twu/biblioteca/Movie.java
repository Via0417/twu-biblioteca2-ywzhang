package com.twu.biblioteca;

public class Movie extends Record{
    private int id;
    private String title;
    private boolean isCheck;
    private String year;
    private String director;
    private int rating;

    public Movie(int id, String title, String year, String director, int rating) {
        super(id, title);
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
}
