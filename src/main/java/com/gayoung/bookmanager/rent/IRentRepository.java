package com.gayoung.bookmanager.rent;

import java.sql.Date;
import java.sql.SQLException;

public interface IRentRepository {
    void addRent(Rent rent) throws SQLException;

    void addReturn(int index);

    String  getBookTitle(int index);

    String getUserName(int index);

    void get(String str, int searchWord);

    void getAll();

    Date getNow();

}
