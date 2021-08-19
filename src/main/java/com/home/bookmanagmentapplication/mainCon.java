package com.home.bookmanagmentapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainCon extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainCon.class.getResource("loginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        stage.setTitle("BMS 2021.0.0 Beta");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}