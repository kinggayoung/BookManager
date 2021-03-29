package com.gayoung.bookmanager.user;

import com.gayoung.bookmanager.book.Book;

import java.util.List;

public interface IUserRepository {
    void add(User user);

    void delete(int index);

    void update(int index, User user);


    void get(String str, String searchWord);

    void getAll();
}
