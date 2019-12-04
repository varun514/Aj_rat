package com.example.bookdescription;

public class Desc {
    private String name, author, mdescrition;

    public Desc(String name, String author, String mdescrition) {
        this.name = name;
        this.author = author;
        this.mdescrition = mdescrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMdescrition() {
        return mdescrition;
    }

    public void setMdescrition(String mdescrition) {
        this.mdescrition = mdescrition;
    }


}
