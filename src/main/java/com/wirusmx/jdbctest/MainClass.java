package com.wirusmx.jdbctest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MainClass
{
    public static void main( String[] args ) throws ClassNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Database name: ");
        String dbName = consoleReader.readLine();

        Connection connection;
        Statement statement;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            return;
        }

        String query;
        System.out.print("> ");
        while (!(query = consoleReader.readLine()).equalsIgnoreCase("exit")) {
            try {
                boolean execute = statement.execute(query);
                if (!execute) {
                    System.out.println("OK");
                    System.out.print("> ");
                    continue;
                }

                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        System.out.print(resultSet.getString(i) + "\t\t");
                    }
                    System.out.println();
                }

            } catch (SQLException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            System.out.print("> ");
        }
    }
}
