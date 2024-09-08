package com.zach.budget.frontend;

import com.zach.budget.enums.AccountTypeEnums;
import com.zach.budget.enums.FrequencyEnums;
import com.zach.budget.models.Account;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import javafx.application.Application;

import java.awt.*;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class BudgetFrontendApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Category List
        ListView<Category> categoryListView = new ListView<>();
        ObservableList<Category> categories = FXCollections.observableArrayList(
                new Category("Home"),
                new Category("Health & Wellness")
        );


        // TODO; specify cell factory
        categoryListView.setCellFactory(clv -> new ListCell<Category>() {
           private TextField textField = new TextField();
           ListView<LineItem> lineItemListView = new ListView<>();
           ObservableList<LineItem> lineItems = FXCollections.observableArrayList(
                    new LineItem("LineItem1", 101.0, LocalDateTime.now(), FrequencyEnums.MONTHLY, true, new Account("chase", AccountTypeEnums.CHECKING), null),
                    new LineItem("LineItem2", 102.0, LocalDateTime.now(), FrequencyEnums.ANNUALLY, true, new Account("usaa", AccountTypeEnums.SAVINGS), null),
                    new LineItem("LineItem3", 103.0, LocalDateTime.now(), FrequencyEnums.QUARTERLY, true, new Account("Amazon", AccountTypeEnums.CREDIT_CARD), null)
            );

//           {
//               textField.setOnAction(e -> {
//                   commitEdit(getItem());
//               });
//               textField.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
//                   if (e.getCode() == KeyCode.ESCAPE) {
//                       cancelEdit();
//                   }
//               });
//           }
//
            @Override
            protected void updateItem(Category category, boolean empty) {
                super.updateItem(category, empty);
                lineItemListView.setEditable(true);
                lineItemListView.setItems(lineItems);

                lineItemListView.setCellFactory(llv -> new ListCell<>() {
                    private TextField descTextField = new TextField();
                    private TextField amountTextField = new TextField();

                    @Override
                    protected void updateItem(LineItem lineItem, boolean empty) {
                        super.updateItem(lineItem, empty);
                        if (empty) {
                            setText(null);
                            setGraphic(null);
                        } else if (isEditing()) {
                            descTextField.setText(lineItem.getDescription());
                            amountTextField.setText(lineItem.getPlannedAmount().toString());
                            setText(null);
                        } else {
                            setText(lineItem.getDescription());
                            amountTextField.setText(lineItem.getPlannedAmount().toString());
                            setGraphic(null);
                        }
                    }
                });

                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else if (isEditing()) {
                    textField.setText(category.getName());
                    setText(null);
//                    setGraphic(textField);
                } else {
                    setText(category.getName());
                    setGraphic(null);
                }
            }
//
//            @Override
//            public void startEdit() {
//                super.startEdit();
//                textField.setText(getItem().getName());
//                setText(null);
//                setGraphic(textField);
//                textField.selectAll();
//                textField.requestFocus();
//            }
//
//            @Override
//            public void cancelEdit() {
//                super.cancelEdit();
//                setText(getItem().getName());
//                setGraphic(null);
//            }
//
//            @Override
//            public void commitEdit(Person person) {
//                super.commitEdit(person);
//                person.setName(textField.getText());
//                setText(textField.getText());
//                setGraphic(null);
//            }
        });


        categoryListView.setEditable(true);
        categoryListView.setItems(categories);

        // for debugging:
        categoryListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                categoryListView.getItems().forEach(p -> System.out.println(p.getName()));
            }
        });

        BorderPane root = new BorderPane();
        Scene scene = new Scene(categoryListView, 500, 500);
        stage.setTitle("My Budget");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
