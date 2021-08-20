package com.home.bookmanagmentapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {
    @FXML
    private Button viewBooks;
    @FXML
    private Button viewUsers;
    @FXML
    private Button viewIssuedBooks;
    @FXML
    private Button issueBook;
    @FXML
    private Button addUser;
    @FXML
    private Button addBook;
    @FXML
    private Button returnBook;
    @FXML
    private Button resetOrCreate;
    @FXML
    private Button returnButton;

    private Scene previousScene = null;

    private void changeScene(Button button, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            previousScene = button.getScene();
            Stage stage = (Stage) button.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onViewBooksPressed() {

    }
    @FXML
    private void onViewUsersPressed() {

    }
    @FXML
    private void onViewIssuedBooksPressed() {

    }
    @FXML
    private void onIssueBooksPressed() {

    }
    @FXML
    private void onAddUserPressed() {

    }
    @FXML
    private void onAddBookPressed() {

    }
    @FXML
    private void onReturnBookPressed() {

    }
    @FXML
    private void onResetOrCreatePressed() {

    }
}
