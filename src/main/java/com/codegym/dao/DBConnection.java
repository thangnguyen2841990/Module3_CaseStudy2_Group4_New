package com.codegym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/caseStudy?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "12012001";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
