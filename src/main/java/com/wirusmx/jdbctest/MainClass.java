package com.wirusmx.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Qwerty");

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            System.exit(0);
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
             PreparedStatement statement = connection.prepareStatement("insert into student (name) values (?);")) {

            statement.setString(1, student.getName());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }


    }

}
