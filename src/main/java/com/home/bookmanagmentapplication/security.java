package com.home.bookmanagmentapplication;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import org.apache.commons.codec.digest.DigestUtils;

public class security {
    public static boolean compare(String username, String password) {
        return username.equals("jestes15") && (DigestUtils.sha256Hex(password)).equals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
    }

    public static Connection connectToDatabase(String username, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BookDatabase", username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
