package com.gayoung.bookmanager.dbConnector;

import java.sql.*;

public class DBConnector {
    private static DBConnector instance;
    public static DBConnector getInstance(){
        if (instance == null){
            instance = new DBConnector();
        }
        return instance;
    }

    private DBConnector(){

    }

    private Connection con;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void disconnect(){

        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public PreparedStatement getPrepareStatement(String sql){
        try {
            return con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }
}
