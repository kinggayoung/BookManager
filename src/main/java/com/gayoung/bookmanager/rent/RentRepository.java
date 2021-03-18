package com.gayoung.bookmanager.rent;

import com.gayoung.bookmanager.book.BookRepository;
import com.gayoung.bookmanager.user.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

public class RentRepository {
    private static RentRepository instance;

    public static RentRepository getInstance() {
        if (instance == null) {
            instance = new RentRepository();
        }
        return instance;
    }

    private RentRepository() {

    }

    private final TreeMap<Integer, Rent> idByRent = new TreeMap<>();
    public void addRent(Rent rent) {
        int index;
        if (idByRent.size() == 0) {
            index = 1;
        } else {
            index = idByRent.lastKey() + 1;
        }


        rent.setIndex(index);

        rent.setUserName(UserRepository.getInstance().getUserName(rent.userIndex));
        rent.setBookTitle(BookRepository.getInstance().getBookTitle(rent.bookIndex));
        rent.setRentDate(getNow());
        rent.setReturnDate("");

        idByRent.put(index, rent);
    }

    public void addReturn(int index, Rent rent) {

        rent.setIndex(index);
        rent.setUserName(UserRepository.getInstance().getUserName(rent.userIndex));
        rent.setBookTitle(BookRepository.getInstance().getBookTitle(rent.bookIndex));
        rent.setRentDate(idByRent.get(index).getRentDate());
        rent.setReturnDate(getNow());

        idByRent.put(index, rent);
    }

    public Collection<Rent> getRents(){
        return idByRent.values();
    }

    public int getBookIndex(int index) {
        return idByRent.get(index).getBookIndex();
    }

    public int getUserIndex(int index) {
        return idByRent.get(index).getUserIndex();
    }

    public String getNow(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");

        Date now = new Date();

        return format.format(now);
    }


}
