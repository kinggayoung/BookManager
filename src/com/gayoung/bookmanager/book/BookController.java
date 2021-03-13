package com.gayoung.bookmanager.book;

import com.gayoung.bookmanager.user.UserController;

import java.util.Scanner;

public class BookController {
    private static  BookController instance;

    public static  BookController getInstance(){
        if (instance == null){
            instance = new BookController();
        }
        return instance;

    }

    private BookController(){

    }

    private final Scanner scanner = new Scanner(System.in);

    public String readBookCode(){
        return scanner.next();
    }

    public String readBookTitle(){
        return scanner.next();
    }

    public String readBookAuthor(){
        return scanner.next();
    }

    public String readBookGenre(){
        return scanner.next();
    }

    public String readBookDate(){
        return scanner.next();
    }
}
