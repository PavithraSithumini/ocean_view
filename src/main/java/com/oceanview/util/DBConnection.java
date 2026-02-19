package com.oceanview.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/oceanview_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    private DBConnection(){}

    public static Connection getConnection() throws Exception {
        if(connection == null || connection.isClosed()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
