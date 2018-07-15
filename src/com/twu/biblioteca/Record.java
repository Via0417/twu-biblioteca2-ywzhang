package com.twu.biblioteca;

public class Record {

    private int id;
    private String title;
    private String year;
    private String authorOrDirector;
    private boolean isCheck;

    public Record(int id, String title, String year, String authorOrDirector){
        this.id = id;
        this.title = title;
        this.year = year;
        this.authorOrDirector = authorOrDirector;
        isCheck = false;
    }

    public String getYear() {
        return year;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorOrDirector() {
        return authorOrDirector;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

}
