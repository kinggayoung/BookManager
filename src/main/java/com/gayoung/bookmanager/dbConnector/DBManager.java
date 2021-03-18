package com.gayoung.bookmanager.dbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {

    }

    public void initialize() throws SQLException {
        String isExitDB = "select schema_name from information_schema.schemata where schema_name = 'book_dev'";
        ResultSet resultSet = DBConnector.getInstance().getPrepareStatement(isExitDB).executeQuery();

        if (resultSet.next()){ // resultSet 값 가져오기
            System.out.println("DB있음");
            return;
        }

        System.out.println("DB생성");

        // executeQuery() : 결과값 가져옴 -> select
        // executeUpdate() : 결과값 없음 -> insert, delete, update

        String createDB = "create database `book_dev` character set 'utf8'";
        DBConnector.getInstance().getPrepareStatement(createDB).executeUpdate();

        String createUserTable = "CREATE TABLE `book_dev`.`user` (\\n\" +\n" +
                "        \"  `id` INT NOT NULL AUTO_INCREMENT,\\n\" +\n" +
                "        \"  `name` VARCHAR(10) NOT NULL,\\n\" +\n" +
                "        \"  `age` INT NOT NULL,\\n\" +\n" +
                "        \"  PRIMARY KEY (`id`))";
        DBConnector.getInstance().getPrepareStatement(createUserTable).executeUpdate();

        String createBookTable = "CREATE TABLE `book_dev`.`book` (\\n\" +\n" +
                "        \"  `id` INT NOT NULL AUTO_INCREMENT,\\n\" +\n" +
                "        \"  `title` VARCHAR(10) NOT NULL,\\n\" +\n" +
                "        \"  `author` VARCHAR(10) NOT NULL,\\n\" +\n" +
                "        \"  `genre` VARCHAR(10) NOT NULL,\\n\" +\n" +
                "        \"  `date` date NOT NULL,\\n\" +\n" +
                "        \"  PRIMARY KEY (`id`))";
        DBConnector.getInstance().getPrepareStatement(createBookTable).executeUpdate();

        String createRentTable = "CREATE TABLE `book_dev`.`rent` (\\n\" +\n" +
                "        \"  `id` INT NOT NULL AUTO_INCREMENT,\\n\" +\n" +
                "        \"  `userID` INT NOT NULL,\\n\" +\n" +
                "        \"  `bookID` INT NOT NULL,\\n\" +\n" +
                "        \"  `rentDate` date NOT NULL,\\n\" +\n" +
                "        \"  `returnDate` date NOT NULL,\\n\" +\n" +
                "        \"  PRIMARY KEY (`id`))";
        DBConnector.getInstance().getPrepareStatement(createRentTable).executeUpdate();

        String useDB = "use book_dev";
        DBConnector.getInstance().getPrepareStatement(useDB).executeUpdate();

    }
}
