package com.twu.biblioteca;

public class Record {

    private int id;
    private String title;
    private boolean isCheck;

    public Record(int id, String title){
        this.id = id;
        this.title = title;
        isCheck = false;
    }
    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheck() {
        return isCheck;
    }
}
