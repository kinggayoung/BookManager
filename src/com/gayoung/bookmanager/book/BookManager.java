package com.gayoung.bookmanager.book;

import com.gayoung.bookmanager.Utill;
import com.gayoung.bookmanager.user.UserController;

import java.util.Scanner;

public class BookManager {

    private static BookManager instance = null;

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public BookManager() {

    }

    private Scanner scanner;
    private final Utill utill = new Utill();

    public void start() {
        scanner = new Scanner(System.in);

        utill.startTitle("도서 관리");

        BookRepository.getInstance().addBook(new Book("830.72ㅇ", "연금술사", "파울로 코엘료", "소설", "1987-01-01"));

        while (true) {
            int i = utill.startSentence4("도서 등록", "도서 수정", "도서 삭제", "도서 검색");

            executeCommand(i);
            printBookList("");

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

            System.out.print("분류코드 : ");
            String code = BookController.getInstance().readBookCode();

            System.out.print("제목 : ");
            String title = BookController.getInstance().readBookTitle();

            System.out.print("저자 : ");
            String author = BookController.getInstance().readBookAuthor();

            System.out.print("장르 : ");
            String genre = BookController.getInstance().readBookGenre();

            System.out.print("출판일 : ");
            String date = BookController.getInstance().readBookDate();

            Book book = new Book(code, title, author, genre, date);
            BookRepository.getInstance().addBook(book);

            if (utill.loop("더 등록할 도서가 있습니까?") == false)
                return;
        }

    }

    private void updateBook() {
        while (true) {

            printBookList("");
            System.out.print("수정할 도서 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            System.out.print("분류코드 : ");
            String code = BookController.getInstance().readBookCode();

            System.out.print("제목 : ");
            String title = BookController.getInstance().readBookTitle();

            System.out.print("저자 : ");
            String author = BookController.getInstance().readBookAuthor();

            System.out.print("장르 : ");
            String genre = BookController.getInstance().readBookGenre();

            System.out.print("출판일 : ");
            String date = BookController.getInstance().readBookDate();

            Book book = new Book(code, title, author, genre, date);
            BookRepository.getInstance().updateBook(key, book);

            if (utill.loop("추가로 수정할 도서가 있습니까?") == false)
                return;

        }
    }

    private void deleteBook() {
        while (true) {
            printBookList("");
            System.out.print("삭제할 도서 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            BookRepository.getInstance().removeBook(key);

            if (utill.loop("추가로 삭제할 도서가 있습니까?") == false)
                return;
        }
    }

    private void searchBook() {
        while (true) {
            System.out.print("검색할 도서 제목을 입력하시오. : ");

            printBookList(scanner.next());

            if (utill.loop("추가로 검색할 도서가 있습니까?") == false)
                return;
        }
    }


    public void printBookList(String word) {
        System.out.println("도서DB");
        System.out.println("\n번호\t\t분류코드\t\t제목\t\t저자\t\t장르\t\t출판일");

        BookRepository.getInstance().getBooks()
                .stream()
                .filter(book -> book.getTitle().contains(word))
                .forEach(book -> System.out.println(book.toString()));
    }

}
