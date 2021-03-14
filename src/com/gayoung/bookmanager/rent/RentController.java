package com.gayoung.bookmanager.rent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RentController {
    private static RentController instance;

    public static RentController getInstance() {
        if (instance == null) {
            instance = new RentController();
        }
        return instance;
    }

    private RentController() {

    }

    private final Scanner scanner = new Scanner(System.in);


    public int readBookIndex() {
        while (true) {
            int bookIndex;

            try {
                bookIndex = scanner.nextInt();
            } catch (Exception exception) {
                System.out.print("제대로 입력 ㄱㄱ");
                scanner.nextLine();
                continue;
            }
            return bookIndex;
        }

    }


    public int readUserIndex() {
        while (true) {
            int userIndex;

            try {
                userIndex = scanner.nextInt();
            } catch (Exception exception) {
                System.out.print("제대로 입력 ㄱㄱ");
                scanner.nextLine();
                continue;
            }
            return userIndex;
        }
    }


}
