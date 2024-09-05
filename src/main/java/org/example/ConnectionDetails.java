package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {
    final static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    final static String URL="jdbc:mysql://localhost:3306/truckmngt";
    final static String USER_NAME="root";
    final static String PASSWORD="pri8850@ncE";

    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
    }

