package com.melshalati.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static Connection myConn = null;

    private ConnectionFactory(){}

    public static Connection getConnnection() throws SQLException {
        if (myConn == null){
            String url = "jdbc:mysql://localhost:3306/webapp";
            String username
            String password
            myConn = DriverManager.getConnection(url, username, password);
        }
        return myConn;
    }
}
