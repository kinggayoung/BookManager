package com.gayoung.bookmanager.rent;

import com.gayoung.bookmanager.book.BookRepository;
import com.gayoung.bookmanager.user.UserRepository;

public class  Rent {
    private int index;
    public int userIndex;
    //private String userName;
    public int bookIndex;
    //private String bookTitle;
    private String rentDate;
    private String returnDate;

    public Rent(int userIndex, int bookIndex) {
        this.userIndex = userIndex;
        this.bookIndex = bookIndex;
    }
    public Rent(){

    }

    public int getIndex() {
        return index;
    }

    public int getUserIndex() {
        return userIndex;
    }

    public int getBookIndex() {
        return bookIndex;
    }

    public String getRentDate() {
        return rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

//    public String getBookTitle() {
//        return bookTitle;
//    }
//
//    public String getUserName() {
//        return userName;
//    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void setRentDate(String rentDate){
        this.rentDate = rentDate;
    }

    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }
//
//    public void setBookTitle(String bookTitle) {
//        this.bookTitle = bookTitle;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    @Override
    public String toString() {
        return getIndex() + "\t\t" +
                UserRepository.getInstance().getUserName(userIndex) + "\t\t" +
                BookRepository.getInstance().getBookTitle(bookIndex) + "\t\t" +
                getRentDate() + "\t\t" +
                getReturnDate() + "\t\t" ;
    }
}
