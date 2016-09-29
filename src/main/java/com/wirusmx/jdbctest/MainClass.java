package com.wirusmx.jdbctest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Database name: ");
        String dbName = consoleReader.readLine();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
             Statement statement = connection.createStatement()) {

            String query;
            System.out.print("> ");
            while (!(query = consoleReader.readLine()).equalsIgnoreCase("exit")) {
                handleQuery(statement, query);
                System.out.print("> ");
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }


    }

    private static void handleQuery(Statement statement, String query) {
        try {
            boolean execute = statement.execute(query);
            if (!execute) {
                System.out.println("OK");
                return;
            }

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + "\t\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
