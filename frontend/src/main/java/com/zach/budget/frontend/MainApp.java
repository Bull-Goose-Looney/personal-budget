package com.zach.budget.frontend;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class MainApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlLocation = getClass().getResource("/com/zach/budget/frontend/views/main_view.fxml");
        if (fxmlLocation == null) {
            throw new RuntimeException("Could not find main_view.fxml");
        }
        Parent root = FXMLLoader.load(fxmlLocation);
        primaryStage.setTitle("Budget Application");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
