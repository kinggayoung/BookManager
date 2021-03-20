package com.gayoung.bookmanager.book;


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

}
