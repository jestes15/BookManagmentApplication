package com.home.bookmanagementapplication;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;

public class security {

    private static String[] getCreds() {
        Properties login = new Properties();
        try (FileReader in = new FileReader("C:\\Users\\bl4z3\\IdeaProjects\\BookManagementApplication\\src\\main\\resources\\com\\home\\bookmanagementapplication\\properties\\login.properties")) {
            login.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{login.getProperty("username"), login.getProperty("password")};
    }

    public static boolean compare(String username, String password) {
        String[] loginInfo = getCreds();
        Connection connection = connectToDatabase(loginInfo[0], loginInfo[1]);
        ResultSet rs = null;
        int admin_privileges = 0;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");

                if ((DigestUtils.sha256Hex(password)).equals(DigestUtils.sha256Hex(passwordDB)) && (DigestUtils.sha256Hex(username)).equals(DigestUtils.sha256Hex(usernameDB))) {
                    admin_privileges = rs.getInt("admin_privileges");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin_privileges == 1;
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
