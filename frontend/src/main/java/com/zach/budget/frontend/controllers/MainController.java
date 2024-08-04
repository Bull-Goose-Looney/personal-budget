package com.zach.budget.frontend.controllers;

import java.net.http.HttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.zach.budget.models.Category;

public class MainController {

    @FXML
    private Button addButton;

    @FXML
    private Label label;

    @FXML
    private TextField categoryNameField;

    @FXML
    private TextField categoryDescriptionField;

    @FXML
    private void handleAddButton(ActionEvent event) {
        String name = categoryNameField.getText();
        String description = categoryDescriptionField.getText();
        Category category = new Category(name, description);
        String response = callBackendApi(category);

    }

    private String callBackendApi(Category category) {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(category);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/category/add"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: Unable to add category";
        }
    }
}
