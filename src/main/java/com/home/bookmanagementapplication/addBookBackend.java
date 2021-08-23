package com.home.bookmanagementapplication;

import com.home.bookmanagementapplication.security;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class addBookBackend {
    @FXML private TextField eanNumberField;
    @FXML private TextField titleField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField priceField;
    @FXML private Button returnButton;
    @FXML private MenuBar menuBar;
    @FXML private Button okButton;

    private String username;
    private String password;

    private final Map<Integer, String> bookArray = new HashMap<>();

    private void changeScene(Scene buttonScene, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = (Stage) buttonScene.getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void onReturnButtonPressed() {
        changeScene(returnButton.getScene(), "main.fxml");
    }
    @FXML private void onCloseButtonPress() {
        System.exit(0);
    }
    @FXML private void onLogoutButtonPressed() {
        changeScene(menuBar.getScene(), "loginForm.fxml");
    }
    @FXML private void onAboutButtonPressed() {
        changeScene(menuBar.getScene(), "aboutForm.fxml");
    }
    private void throwError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }

    private void loginToDB() {
        Properties login = new Properties();
        try (FileReader in = new FileReader("C:\\Users\\bl4z3\\IdeaProjects\\BookManagementApplication\\src\\main\\resources\\com\\home\\bookmanagementapplication\\properties\\login.properties")) {
            login.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = login.getProperty("username");
        password = login.getProperty("password");
    }

    @FXML private void onAddButtonPressed() {
        try {
            long EAN = Long.parseLong(eanNumberField.getText()); // NumberFormatException thrown here
            String title = (titleField.getText().length() < 512) ? titleField.getText() : null;
            String firstName = (firstNameField.getText().length() < 512) ? firstNameField.getText() : null;
            String lastName = (lastNameField.getText().length() < 512) ? lastNameField.getText() : null;
            float price = Float.parseFloat(priceField.getText());

            String statement = String.format("INSERT INTO public.books (ean, title, author_last_name, author_first_name, price) VALUES (%d, '%s', '%s', '%s', %f);",
                    EAN, title, lastName, firstName, price);

            bookArray.put(bookArray.size(), statement);
        } catch (NumberFormatException e) {
            throwError();
            e.printStackTrace();
        }
    }

    @FXML private void onSubmitButtonPressed() {
        loginToDB();
        Connection con = security.connectToDatabase(username, password);

        for (Map.Entry<Integer,String> x : bookArray.entrySet())
            System.out.println(x);

        try {
            Statement stmt = con.createStatement();
            for (Map.Entry<Integer,String> x : bookArray.entrySet())
                stmt.execute(x.getValue());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
