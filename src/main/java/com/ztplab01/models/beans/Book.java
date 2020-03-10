package com.ztplab01.models.beans;

public class Book {
    private int id;
    private String title;
    private String author;
    private String releasedDate;
    private String genre;

    public Book(int id) {
        this.id = id;
        this.title = "title";
        this.author = "author";
        this.releasedDate = "releasedDate";
        this.genre = "genre";
    }

    public Book(String title, String author, String releasedDate, String genre) {
        this.title = title;
        this.author = author;
        this.releasedDate = releasedDate;
        this.genre = genre;
    }

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

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return id+ " " + title + " " + author + " " +  releasedDate + " " + genre;
    }
}
