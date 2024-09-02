package com.zach.budget.frontend.controllers;

import java.net.URL;
import java.net.http.HttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.zach.budget.models.LineItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import com.zach.budget.models.Category;

import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @FXML
    private BorderPane borderPane;

    @FXML
    private ListView<Category> categoryListView;

	private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private ObservableList<Category> categories = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set custom cell factory
        categoryListView.setCellFactory(new Callback<>() {
            @Override
            public CategoryCellController call(ListView<Category> param) {
                return new CategoryCellController();
            }
        });
        loadCategories();
    }

    private void loadCategories() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/category/categories"))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Deserialize the JSON response to a list of Category objects
                List<Category> categories = Arrays.asList(objectMapper.readValue(response.body(), Category[].class));
                for(Category cat: categories) {
                    LOGGER.info("Category: {} has line items: ", cat.getName());
                    for(LineItem lineItem : cat.getLineItems()) {
                        LOGGER.info("Category: {}", lineItem.getName());
                    }
                }
                // Convert list to ObservableList for JavaFX
	            ObservableList<Category> observableCategories = FXCollections.observableArrayList(categories);

                // Update the ListView with the categories
                categoryListView.setItems(observableCategories);

            } else {
                // Handle non-200 responses
                System.err.println("Failed to fetch categories: " + response.statusCode());
            }

        } catch (Exception e) {
            LOGGER.error("Failed to load Categories");
        }
    }

    public void addCategory(Category category) {
        try {
            // Convert the Category object to a JSON string
            String requestBody = objectMapper.writeValueAsString(category);

            // Create the POST request to add a new category
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/category/add"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .header("Content-Type", "application/json")
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Category added: " + response.body());
                // Refresh the category list or update the UI accordingly
                loadCategories();
            } else {
                System.err.println("Failed to add category: HTTP " + response.statusCode());
            }

        } catch (Exception e) {
            LOGGER.error("Failed to add Category");
        }
    }


}