package com.gayoung.bookmanager.rent;

import java.sql.Date;
import java.time.LocalDate;

public class  Rent {
    private int index;
    public int userIndex;
    public int bookIndex;
    private LocalDate rentDate;
    private LocalDate returnDate;

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

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }


    public void setIndex(int index) {
        this.index = index;
    }
    public void setRentDate(LocalDate rentDate){
        this.rentDate = rentDate;
    }

    public void setReturnDate(LocalDate returnDate){
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
//        return getIndex() + "\t\t" +
//                UserRepository.getInstance().getUserName(userIndex) + "\t\t" +
//                BookRepository.getInstance().getBookTitle(bookIndex) + "\t\t" +
//                getRentDate() + "\t\t" +
//                getReturnDate() + "\t\t" ;
        return "";
    }
}
