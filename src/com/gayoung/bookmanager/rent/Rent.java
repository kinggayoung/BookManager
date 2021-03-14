package com.gayoung.bookmanager.rent;

public class  Rent {
    int index;
    int userIndex;
    String userName;
    int bookIndex;
    String bookTitle;
    String rentDate;
    String returnDate;

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

    public String getBookTitle() {
        return bookTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void setRentDate(String rentDate){
        this.rentDate = rentDate;
    }

    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return getIndex() + "\t\t" +
                getUserName() + "\t\t" +
                getBookTitle() + "\t\t" +
                getRentDate() + "\t\t" +
                getReturnDate() + "\t\t" ;
    }
}
