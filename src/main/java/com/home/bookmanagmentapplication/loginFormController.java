package com.home.bookmanagmentapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class loginFormController {

    private String username;
    private String password;
    @FXML private TextField user;
    @FXML private PasswordField loginPasswordField;
    @FXML private Button loginButton;

    private boolean submit() {
        return security.compare(username, password);
    }
    private void throwError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
    @FXML protected void onLoginButtonClicked() throws IOException {
        username = user.getText();
        password = loginPasswordField.getText();

        Properties login = new Properties();
        try (FileReader in = new FileReader("C:\\Users\\bl4z3\\IdeaProjects\\BookManagmentApplication\\src\\main\\resources\\com\\home\\bookmanagmentapplication\\login.properties")) {
            login.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = login.getProperty("username");
        String password = login.getProperty("password");

        if (submit()) {
            Connection con = security.connectToDatabase(username, password);
            try {
                con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            throwError("ERROR", "Your username or password was incorrect");
        }
    }
}