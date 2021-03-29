package com.gayoung.bookmanager.book;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public interface IBookRepository {
    void add(Book book);

    void delete(int index);

    void update(int index, Book book);



    void get(String str, String searchWord);

    void getAll();

}
