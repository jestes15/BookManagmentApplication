package com.home.bookmanagmentapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class loginFormController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private Button loginButton;

    private String username;
    private String password;

    private boolean submit() {
        return security.compare(username, password);
    }

    @FXML
    protected void onLoginButtonClicked() {
        username = user.getText();
        password = loginPasswordField.getText();

        if (submit()) {
            System.out.println("Works");
        }
    }
}