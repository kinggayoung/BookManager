package com.gayoung.bookmanager.book;

public class Book {
    private int index;
    private final String code;
    private static String title;
    private final String author;
    private final String genre;
    private final String date;



    public Book(String code, String title, String author, String genre, String date) {
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public static String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return  getIndex() + "\t\t" +
                getCode() + "\t\t" +
                getTitle() + "\t\t" +
                getAuthor() + "\t\t" +
                getGenre() + "\t\t" +
                getDate() + "\t\t";

    }
}
