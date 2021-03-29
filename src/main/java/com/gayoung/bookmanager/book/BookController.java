package com.gayoung.bookmanager.book;

import com.gayoung.bookmanager.Utill;

import java.time.LocalDate;
import java.util.Scanner;

public class BookController {

    private static BookController instance = null;

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    public BookController() {

    }

    private Scanner scanner;
    private final Utill utill = new Utill();
    private BookRepository bookRepository = BookRepository.getInstance();

    public void start() {
        scanner = new Scanner(System.in);

        utill.startTitle("도서 관리");

       // bookRepository.addBook(new Book("830.72ㅇ", "연금술사", "파울로 코엘료", "소설", "1987-01-01"));

        while (true) {
            int i = utill.startSentence4("도서 등록", "도서 수정", "도서 삭제", "도서 검색");

            executeCommand(i);
            printBookList();

            if (!utill.loop("추가로 도서 관리하겠습니까?"))
                return;
        }


    }


    private void executeCommand(int commandNumber) {
        switch (commandNumber) {
            case 1:
                insertBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                deleteBook();
                break;
            case 4:
                searchBook();
                break;
        }
    }

    private void insertBook() {
        while (true) {

            System.out.println("\n정보를 입력하시오.");

            bookRepository.add(readBook());

            if (utill.loop("더 등록할 도서가 있습니까?") == false)
                return;
        }

    }

    private void updateBook() {
        while (true) {

            printBookList();
            System.out.print("수정할 도서 번호를 입력하시오. : ");
             int key = scanner.nextInt();

            System.out.print("수정할 도서 정보를 입력하시오. \n1. 분류코드   2. 제목   3. 저자   4. 장르   5. 출판일  : ");

            bookRepository.update(key, readBook());

            if (utill.loop("추가로 수정할 도서가 있습니까?") == false)
                return;

        }
    }

    private void deleteBook() {
        while (true) {
            printBookList();
            System.out.print("삭제할 도서 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            bookRepository.delete(key);

            if (utill.loop("추가로 삭제할 도서가 있습니까?") == false)
                return;
        }
    }

    private void searchBook() {
        while (true) {
            System.out.print("검색할 도서 번호나 제목을 입력하시오. : ");
            String searchWord = scanner.next();


            if (utill.IntStringGubun(searchWord) == true){
                bookRepository.get("id", searchWord);
            }else{
                bookRepository.get("title", searchWord);
            }


            if (utill.loop("추가로 검색할 도서가 있습니까?") == false)
                return;
        }
    }


    public void printBookList() {
        System.out.println("도서DB");
       // System.out.println("\n번호\t\t제목\t\t저자\t\t장르\t\t출판일");

        bookRepository.getAll();
    }

    private Book readBook(){

        System.out.print("제목 : ");
        String title = utill.readSaftyString();

        System.out.print("저자 : ");
        String author = utill.readSaftyString();

        System.out.print("장르 : ");
        String genre = utill.readSaftyString();

        System.out.print("출판일 : ");
        LocalDate date = LocalDate.parse(utill.readSaftyString());

        Book book = new Book(0, title, author, genre, date);

        return book;
    }

}
