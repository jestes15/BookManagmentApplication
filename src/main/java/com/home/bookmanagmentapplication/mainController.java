package com.home.bookmanagmentapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {
    @FXML private Button viewBooks;
    @FXML private Button viewUsers;
    @FXML private Button viewIssuedBooks;
    @FXML private Button issueBook;
    @FXML private Button addUser;
    @FXML private Button addBook;
    @FXML private Button returnBook;
    @FXML private MenuBar menuBar;
    @FXML private Button okButton;

    private void changeScene(Button button, String fxmlFile) {
        changeScene(fxmlFile, button.getScene());
    }
    private void changeScene(MenuBar bar, String fxmlFile) {
        changeScene(fxmlFile, bar.getScene());
    }
    private void changeScene(String fxmlFile, Scene scene2) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = (Stage) scene2.getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void onViewBooksPressed() {
        changeScene(viewBooks, "viewBooksScene.fxml");
    }
    @FXML private void onViewUsersPressed() {
        changeScene(viewUsers, "viewUsersScene.fxml");
    }
    @FXML private void onViewIssuedBooksPressed() {
        changeScene(viewIssuedBooks, "viewIssuedBooksScene.fxml");
    }
    @FXML private void onIssueBooksPressed() {
        changeScene(issueBook, "issueBookScene.fxml");
    }
    @FXML private void onAddUserPressed() {
        changeScene(addUser, "addUserScene.fxml");
    }
    @FXML private void onAddBookPressed() {
        changeScene(addBook, "addBookScene.fxml");
    }
    @FXML private void onReturnBookPressed() {
        changeScene(returnBook, "returnBookScene.fxml");
    }

    @FXML private void onCloseButtonPress() {
        System.exit(0);
    }
    @FXML private void onLogoutButtonPressed() {
        changeScene(menuBar, "loginForm.fxml");
    }
    @FXML private void onAboutButtonPressed() {
        changeScene(menuBar, "aboutForm.fxml");
    }
    @FXML private void onOkButtonPressed() {
        changeScene(okButton, "main.fxml");
    }
}
