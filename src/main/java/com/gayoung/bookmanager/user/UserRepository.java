package com.gayoung.bookmanager.user;

import com.gayoung.bookmanager.dbConnector.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class UserRepository implements IUserRepository {
    // Singleton Pattern
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {

    }

    // UserManager Function
    private final TreeMap<Integer, User> idByUser = new TreeMap<>();
    private DBConnector dbConnector = DBConnector.getInstance();



    @Override
    public void add(User user) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "insert into book_dev.user (name, age) values (?,?);"
        );

        try {

            ps.setString(1, user.getName());
            ps.setString(2, String.valueOf(user.getAge()));


            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int index;

        if (idByUser.size() == 0) {
            index = 1;
        } else {
            index = idByUser.lastKey() + 1;
        }

        idByUser.put(index, user);

    }



    @Override
    public void delete(int index) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "delete from book_dev.user where id = ?;"
        );

        try {
            ps.setString(1, String.valueOf(index));


            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        idByUser.remove(index);
    }

    @Override
    public void update(int index, User user) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "update book_dev.user set name = ?, age = ? where id = ?;"
        );

        try {
            ps.setString(1, user.getName());
            ps.setString(2, String.valueOf(user.getAge()));
            ps.setInt(3, index);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void get(String str, String searchWord) {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select * from book_dev.user where "+ str + " = ?;"
        );
        try {

            ps.setString(1, searchWord);

            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {

                System.out.println( "User{" +
                        "index=" + rs.getInt("id") +
                        ", name='" + rs.getString("name") + '\'' +
                        ", age='" + rs.getInt("age") + "'}");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void getAll() {
        PreparedStatement ps = dbConnector.getPrepareStatement(
                "select * from book_dev.user;"
        );
        try {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println( "User{" +
                        "index=" + rs.getInt("id") +
                        ", name='" + rs.getString("name") + '\'' +
                        ", age='" + rs.getInt("age") + "'}");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



}
