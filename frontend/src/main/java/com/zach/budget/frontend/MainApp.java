package com.zach.budget.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/zach/budget/frontend/views/main_view.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/com/zach/budget/frontend/views/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Personal Budget");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
