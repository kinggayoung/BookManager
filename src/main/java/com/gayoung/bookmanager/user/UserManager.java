package com.gayoung.bookmanager.user;

import com.gayoung.bookmanager.Utill;

import java.util.Scanner;

public class UserManager {

    private static UserManager instance = null;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private UserManager() {
    }

    // UserManager Funtion
    private Scanner scanner;
    private final Utill utill = new Utill();
    private UserRepository userRepository = UserRepository.getInstance();
    private UserController userController = UserController.getInstance();

    public void start() {
        scanner = new Scanner(System.in);

        utill.startTitle("사용자 관리");
        userRepository.addUser(new User("김가영", 21, 'W'));

        while (true) {
            int i = utill.startSentence4("사용자 등록", "사용자 수정", "사용자 삭제", "사용자 검색");
            executeCommand(i);
            printUserList("");
            if (!utill.loop("추가로 사용자 관리하겠습니까?"))
                return;
        }

    }

    private void executeCommand(int commandNumber) {
        switch (commandNumber) {
            case 1:
                insertUser();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                deleteUser();
                break;
            case 4:
                searchUser();
                break;
        }
    }


    private void insertUser() {
        while (true) {

            System.out.println("\n정보를 입력하시오.");

            userRepository.addUser(readUser());

            if (!utill.loop("더 등록할 사용자가 있습니까?"))
                return;
        }
    }

    private void updateUser() {
        while (true) {
            printUserList("");

            System.out.print("수정할 사용자 번호를 입력하시오. : ");
            int index = scanner.nextInt();

            userRepository.updateUser(index, readUser());

            if (!utill.loop("추가로 수정할 사용자가 있습니까?")) {
                return;
            }
        }
    }

    private void deleteUser() {
        while (true) {
            printUserList("");
            System.out.print("삭제할 사용자 번호를 입력하시오. : ");
            int key = scanner.nextInt();
            userRepository.removeUser(key);
            if (!utill.loop("추가로 삭제할 사용자가 있습니까?"))
                return;
        }
    }

    private void searchUser() {
        while (true) {
            System.out.print("검색할 사용자 이름을 입력하시오. : ");
            printUserList(scanner.next());
            if (!utill.loop("추가로 검색할 사용자가 있습니까?"))
                return;
        }
    }

    public void printUserList(String word) {
        System.out.println("사용자DB");
        System.out.println("\n번호\t\t이름\t\t나이\t\t성별");
        userRepository.getUsers()
                .stream()
                .filter(user -> user.getName().contains(word))
                .forEach(user -> System.out.println(user.toString()));
    }

    private User readUser(){
        System.out.print("이름 : ");
        String name = utill.readSaftyString();

        System.out.print("나이 : ");
        int age = utill.readSaftyInt();

        System.out.print("성별 : ");
        char gender = userController.readUserGender();

        User user = new User(name, age, gender);
        return user;

    }

}
