package com.zach.budget.frontend;

import com.zach.budget.frontend.controllers.CategoryController;
import com.zach.budget.models.Category;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.List;

public class BudgetFrontendApplication extends Application {
    Stage window;
    Button button;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        window = primaryStage;
        window.setTitle("Zach's Budget");
        button = new Button("Click Me");

        BorderPane layout = new BorderPane();

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

}
