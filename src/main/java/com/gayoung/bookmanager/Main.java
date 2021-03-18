package com.gayoung.bookmanager;

import com.gayoung.bookmanager.book.BookManager;
import com.gayoung.bookmanager.dbConnector.DBConnector;
import com.gayoung.bookmanager.dbConnector.DBManager;
import com.gayoung.bookmanager.rent.RentOrReturn;
import com.gayoung.bookmanager.user.UserManager;

import java.sql.SQLException;

public class Main {
    static UserManager userManager = UserManager.getInstance();
    static BookManager bookManager = new BookManager();
    static RentOrReturn rentOrReturn = new RentOrReturn();
    static Utill utill = new Utill();

    public static void main(String[] args) throws SQLException {
        DBConnector.getInstance().connect();
        DBManager.getInstance().initialize();

        do {
            utill.startTitle("com.gayoung.bookmanager.Main");

            int i = utill.startSentence3("사용자 관리", "도서 관리", "대여 및 반납");

            move(i);

            if (!utill.loop("추가로 관리할 항목이 있습니까?")) {
                System.out.println("프로그램을 종료합니다. 빠빠이~★");

                DBConnector.getInstance().disconnect();
                return;
            }
        } while (true);


    }



    private static void move(int i) {
        switch (i) {
            case 1:
                userManager.start();
                break;
            case 2:
                bookManager.start();
                break;
            case 3:
                rentOrReturn.start();
                break;
        }
    }


}
