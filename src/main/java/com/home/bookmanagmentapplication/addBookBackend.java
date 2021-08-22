package com.home.bookmanagmentapplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class addBookBackend {
    @FXML private TextField eanNumberField;
    @FXML private TextField titleField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField priceField;
    @FXML private Button returnButton;
    @FXML private MenuBar menuBar;
    @FXML private Button okButton;

    private Object[][] bookArray;

    private void changeScene(@NotNull Button button, String fxmlFile) {
        changeScene(fxmlFile, button.getScene());
    }
    private void changeScene(@NotNull MenuBar bar, String fxmlFile) {
        changeScene(fxmlFile, bar.getScene());
    }
    private void changeScene(String fxmlFile, @NotNull Scene scene2) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = (Stage) scene2.getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void onReturnButtonPressed() {
        changeScene(returnButton, "main.fxml");
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
    private void throwError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }

    @FXML private void onAddButtonPressed() {
        try {
            int EAN = Integer.parseInt(eanNumberField.getText());
            String title = (titleField.getText().length() < 512) ? titleField.getText() : null;
            String firstName = (firstNameField.getText().length() < 512) ? firstNameField.getText() : null;
            String lastName = (lastNameField.getText().length() < 512) ? lastNameField.getText() : null;
            float price = Float.parseFloat(priceField.getText());

            bookArray[0] = new Object[]{EAN, title, firstName, lastName, price};
        } catch (NumberFormatException e) {
            throwError();
            e.printStackTrace();
        }
    }
}
