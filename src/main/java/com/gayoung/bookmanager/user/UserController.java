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

    public String readUserName() {
        return scanner.next();
    }

    public int readUserAge() {
        while (true) {
            int age;
            try {
                age = scanner.nextInt();
            } catch (Exception exception) {
                System.out.print("야! 제대로 입력 안하고 뭐하는거야! 어! : ");
                scanner.nextLine();
                continue;
            }
            return age;
        }
    }

    public char readUserGender() {
        return scanner.next().charAt(0);
    }

}
