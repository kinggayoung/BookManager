package com.gayoung.bookmanager.user;

import java.util.Scanner;

public class UserController {

    private static UserController instance;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    private UserController() {

    }

    private final Scanner scanner = new Scanner(System.in);

    public char readUserGender() {
        return scanner.next().charAt(0);
    }

}
