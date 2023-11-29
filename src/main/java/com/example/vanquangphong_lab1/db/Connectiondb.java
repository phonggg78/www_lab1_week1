package com.example.vanquangphong_lab1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
    private static final String url = "jdbc:mariadb://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "sapassword";

    public static Connection createConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("MariaDB Driver found");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            return connection;
        } catch (SQLException e1) {
            System.out.println("Error: " + e1.getMessage());
        }
        return null;
    }

}
