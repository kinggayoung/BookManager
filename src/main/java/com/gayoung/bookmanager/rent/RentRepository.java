package com.gayoung.bookmanager.rent;

import com.gayoung.bookmanager.dbConnector.DBConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeMap;

public class RentRepository implements IRentRepository {
    private static RentRepository instance;

    public static RentRepository getInstance() {
        if (instance == null) {
            instance = new RentRepository();
        }
        return instance;
    }

    private RentRepository() {

    }

    private final TreeMap<Integer, Rent> idByRent = new TreeMap<>();
    private DBConnector dbConnector = DBConnector.getInstance();

    public void addRent(Rent rent) {
        try {
            PreparedStatement ps = dbConnector.getPrepareStatement(
                    "insert into book_dev.rent (userID, bookID,rentDate) values (?,?,now());"
            );

            ps.setInt(1, rent.getUserIndex());
            ps.setInt(2, rent.getBookIndex());


            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int index;

        if(idByRent.size() == 0){
            index = 1;
        }else{
            index = idByRent.lastKey() + 1;
        }
        idByRent.put(index, rent);
    }


    public void addReturn(int index) {
        try {
            PreparedStatement ps = dbConnector.getPrepareStatement(
                    "update book_dev.rent set returnDate = now() where id = ?;"
            );

            ps.setInt(1, index);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public String getBookTitle(int index) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select title from book_dev.book where id = ?;"
        );
        try {

            ps.setInt(1, index);

            ResultSet rs =  ps.executeQuery();

            while (rs.next()){
                return rs.getString("title");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return "";

    }

    @Override
    public String getUserName(int index) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select name from book_dev.user where id = ?;"
        );
        try {

            ps.setInt(1, index);

            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                return rs.getString("name");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return "";
    }

    @Override
    public void get(String str, int searchWord) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select * from book_dev.rent where "+ str + " = ?;"
        );
        try {

            ps.setInt(1, searchWord);

            ResultSet rs =  ps.executeQuery();


            while (rs.next()) {

                System.out.println( "Rent{" +
                        "index=" + rs.getInt("id") +
                        ", userName='" + getUserName(rs.getInt("userID")) + '\'' +
                        ", bookTitle='" + getBookTitle(rs.getInt("bookID")) + '\'' +
                        ", rentDate='" + rs.getDate("rentDate") + '\'' +
                        ", returnDate='" + rs.getDate("returnDate") + "'}");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void getAll() {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select * from book_dev.rent;"
        );
        try {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println( "Rent{" +
                        "index=" + rs.getInt("id") +
                        ", userName='" + getUserName(rs.getInt("userID")) + '\'' +
                        ", bookTitle='" + getBookTitle(rs.getInt("bookID")) + '\'' +
                        ", rentDate='" + rs.getDate("rentDate") + '\'' +
                        ", returnDate='" + rs.getDate("returnDate") + "'}");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Date getNow() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        Date now = new Date();
//
//        return Date.valueOf(format.format(now));


        Calendar cal = new GregorianCalendar();
        Date date = new Date(cal.getTimeInMillis());
        return  date;

//        LocalDate localDate = LocalDate.from(Instant.now().atOffset(ZoneOffset.UTC).toLocalDateTime());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//        return Date.valueOf(localDate.format(formatter));
    }


}
