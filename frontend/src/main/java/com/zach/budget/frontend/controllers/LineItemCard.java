package com.zach.budget.frontend.controllers;

import com.zach.budget.models.LineItem;
import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LineItemCard extends ListCell<LineItem> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LineItemCard.class);

	@FXML
	private HBox root;

	@FXML
	private TextField nameField;

	@FXML
	private TextField plannedAmountField;

	@FXML
	private TextField actualAmountField;

	@FXML
	private ComboBox<DateEnums> dueDateComboBox;

	@FXML
	private ComboBox<FrequencyEnums> frequencyComboBox;

	public LineItemCard() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/LineItemCard.fxml"));
		fxmlLoader.setController(this);
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			LOGGER.error("Failed to load FXML");
		}
	}

	@Override
	protected void updateItem(LineItem lineItem, boolean empty) {
		super.updateItem(lineItem, empty);
		if (empty || lineItem == null) {
			setGraphic(null);
		} else {
			nameField.setText(lineItem.getName());
			plannedAmountField.setText(lineItem.getPlannedAmount().toString());
			actualAmountField.setText(lineItem.getActualAmount().toString());
			dueDateComboBox.getItems().setAll(DateEnums.values());
			dueDateComboBox.setValue(lineItem.getDate());
			frequencyComboBox.getItems().setAll(FrequencyEnums.values());
			frequencyComboBox.setValue(lineItem.getFrequency());

			// Add listeners or actions to update the LineItem when fields are edited
			nameField.textProperty().addListener((observable, oldValue, newValue) -> {
				lineItem.setName(newValue);
			});

			plannedAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
				try {
					lineItem.setPlannedAmount(Double.valueOf(newValue));
				} catch (NumberFormatException e) {
					// Handle invalid input
					LOGGER.error("INVALID INPUT");
				}
			});

			actualAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
				try {
					lineItem.setActualAmount(Double.valueOf(newValue));
				} catch (NumberFormatException e) {
					LOGGER.error("INVALID INPUT");
				}
			});

			dueDateComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
				lineItem.setDate(newValue);
			});

			frequencyComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
				lineItem.setFrequency(newValue);
			});

			setGraphic(root);
		}
	}
}
