package com.gayoung.bookmanager.book;

import com.gayoung.bookmanager.dbConnector.DBConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class BookRepository implements IBookRepository {

    private static BookRepository instance;

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }

        return instance;
    }

    private BookRepository() {

    }

    private DBConnector dbConnector = DBConnector.getInstance();

    private final TreeMap<Integer, Book> idByBook = new TreeMap<>();

    @Override
    public void add(Book book) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "insert into book_dev.book (title, author, genre, date) values (?,?,?,?);"
        );

        try {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            ps.setDate(4, Date.valueOf(book.getDate()));

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int index;

        if (idByBook.size() == 0) {
            index = 1;
        } else {
            index = idByBook.lastKey() + 1;
        }

        idByBook.put(index, book);

    }

    @Override
    public void delete(int index) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "delete from book_dev.book where id = ?;"
        );

        try {
            ps.setString(1, String.valueOf(index));


            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        idByBook.remove(index);
    }

    @Override
    public void update(int index, Book book) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "update book_dev.book set title = ?, author = ?, genre = ?, date = ? where id = ?;"
        );

        try {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            ps.setDate(4, Date.valueOf(book.getDate()));
            ps.setInt(5, index);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    @Override
    public void get(String str, String searchWord) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select * from book_dev.book where "+ str + " = ?;"
        );
        try {

            ps.setString(1, searchWord);

           ResultSet rs =  ps.executeQuery();

            while (rs.next()) {

                System.out.println( "Book{" +
                        "index=" + rs.getInt("id") +
                        ", title='" + rs.getString("title") + '\'' +
                        ", author='" + rs.getString("author") + '\'' +
                        ", genre='" + rs.getString("genre") + '\'' +
                        ", date=" + rs.getDate("date"));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void getAll() {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select * from book_dev.book;"
        );
        try {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println( "Book{" +
                        "index=" + rs.getInt("id") +
                        ", title='" + rs.getString("title") + '\'' +
                        ", author='" + rs.getString("author") + '\'' +
                        ", genre='" + rs.getString("genre") + '\'' +
                        ", date=" + rs.getDate("date"));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

