package com.gayoung.bookmanager.rent;

import com.gayoung.bookmanager.Utill;
import com.gayoung.bookmanager.book.BookManager;
import com.gayoung.bookmanager.user.UserManager;

import java.util.Scanner;

public class RentOrReturn {
    private static RentOrReturn instance;
    private static RentOrReturn getInstance(){
        if (instance == null){
            instance = new RentOrReturn();
        }
        return instance;
    }

    public RentOrReturn(){

    }

    private Scanner scanner;
    private final Utill utill = new Utill();

    public void start(){
        scanner = new Scanner(System.in);

        utill.startTitle("대여 및 반납");
        RentRepository.getInstance().addRent(new Rent(1,1));

        while (true){
            int i = utill.startSentence3("대여하기", "반납하기", "대여현황 검색");
            executeCommand(i);
            printRentList("");

            if (!utill.loop("추가로 도서를 대여 및 반납하겠습니까?")){
                return;
            }
        }
    }

    private void printRentList(String word) {
        System.out.println("도서 대여 현황");
        System.out.println("\n번호\t\t사용자명\t\t책 제목\t\t대여일\t\t반납일");

        RentRepository.getInstance().getRents()
                .stream()
                .filter(rent -> rent.getBookTitle().contains(word))
                .forEach(rent -> System.out.println(rent.toString()));
    }

    private void executeCommand(int commandNumber) {
        switch (commandNumber){
            case 1:
                bookRent();
                return;
            case 2:
                bookReturn();
                return;
            case 3:
                searchRentList();
                return;
        }
    }


    private void bookRent() {
        while (true){

            System.out.println("\n대여할 정보를 입력하시오.");

            UserManager.getInstance().printUserList("");
            System.out.print("대여하실 사용자 번호를 입력하시오.");
            int userIndex = RentController.getInstance().readUserIndex();

            BookManager.getInstance().printBookList("");
            System.out.print("대여할 책 번호를 입력하시오.");
            int bookIndex = RentController.getInstance().readBookIndex();

            Rent rent = new Rent(userIndex, bookIndex);
            RentRepository.getInstance().addRent(rent);

            if (!utill.loop("추가로 대여하겠습니까?")){
                return;
            }

        }

    }



    private void bookReturn() {
        while (true) {


            System.out.println("\n반납할 도서대여 번호를 입력하시오.");

            printRentList("");
            int returnIndex = scanner.nextInt();

            int userIndex = RentRepository.getInstance().getUserIndex(returnIndex);
            int bookIndex = RentRepository.getInstance().getBookIndex(returnIndex);

            Rent rent = new Rent(userIndex, bookIndex);
            RentRepository.getInstance().addReturn(returnIndex, rent);


            if (!utill.loop("추가로 반납하시겠습니까?")){
                return;
            }
        }
    }


    private void searchRentList() {
        while (true){
            System.out.print("검색할 책 제목을 입력하시오 : ");
            printRentList(scanner.next());

            if (!utill.loop("추가로 검색할 대여목록이 있습니까?")){
                return;
            }
        }
    }
}
