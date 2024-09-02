package com.zach.budget.frontend.controllers;

import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryCellController  extends ListCell<Category> implements Initializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryCellController.class);

	@FXML
	private VBox root;

	@FXML
	private Label categoryNameLabel;

	@FXML
	private ListView<LineItem> lineItemsListView;

	public CategoryCellController() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/zach/budget/frontend/views/category_cell.fxml"));
		fxmlLoader.setController(this);
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			LOGGER.error("Failed to load FXML");
		}
	}

	@Override
	protected void updateItem(Category category, boolean empty) {
		super.updateItem(category, empty);
		if (empty || category == null) {
			LOGGER.error("Category Empty");
			setGraphic(null);
		} else {
			categoryNameLabel.setText(category.getName());
			lineItemsListView.getItems().setAll(category.getLineItems());

//			 Set the cell factory for the LineItems ListView
			lineItemsListView.setCellFactory(param -> new LineItemCard());

			setGraphic(root);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOGGER.info("Initialized");
	}
}
