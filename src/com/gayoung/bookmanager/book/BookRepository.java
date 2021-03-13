package com.gayoung.bookmanager.book;

import java.util.Collection;
import java.util.TreeMap;

public class BookRepository {

    private static BookRepository instance;

    public static BookRepository getInstance(){
        if (instance == null){
            instance = new BookRepository();
        }

        return instance;
    }

    private BookRepository(){

    }

    private final TreeMap<Integer, Book> idByBook = new TreeMap<>();

    public void addBook(Book book){
        int index;

        if (idByBook.size() == 0) {
            index = 1;
        } else {
            index = idByBook.lastKey() + 1;
        }

        book.setIndex(index);
        idByBook.put(index, book);
    }

    public void updateBook(int index, Book book){
        book.setIndex(index);
        idByBook.put(index, book);
    }

    public void removeBook(int index){
        idByBook.remove(index);
    }

    public Book getBook(int index) {
        return idByBook.get(index);
    }

    public Collection<Book> getBooks(){
        return idByBook.values();
    }

}
