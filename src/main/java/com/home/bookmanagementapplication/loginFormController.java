package com.home.bookmanagementapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class loginFormController {

    private String username;
    private String password;
    @FXML private TextField user;
    @FXML private PasswordField loginPasswordField;
    @FXML private Button loginButton;

    private boolean submit() {
        return security.compare(username, password);
    }
    private void throwError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("Your username or password was incorrect");

        alert.showAndWait();
    }
    @FXML protected void onLoginButtonClicked() {
        username = user.getText();
        password = loginPasswordField.getText();

        if (submit()) {
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
            throwError();
        }
    }
}