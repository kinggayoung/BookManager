package com.gayoung.bookmanager.book;

import java.sql.Date;
import java.time.LocalDate;

public class Book {
    private int index;
    private String title;
    private String author;
    private String genre;
    private LocalDate date;


    public Book(int index, String title, String author, String genre, LocalDate date) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.date = date;
    }

    public void setIndex(int index) {
        this.index = index;
    }



    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getDate() {
        return date;
    }



    @Override
    public String toString() {
        return "Book{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", date=" + date +
                '}';
    }
}
