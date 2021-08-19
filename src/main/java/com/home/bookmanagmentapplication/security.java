package com.home.bookmanagmentapplication;

import java.sql.*;

public class security {

    public static boolean compare(String username, String password) {
        return username.equals("jestes15") && password.equals("SAMsung-2002");
    }

    public static Connection connectToDatabase(String username, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            Driver d = DriverManager.getDriver("org.postgresql.Driver");
            DriverManager.registerDriver(d);
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BookDatabase", username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
