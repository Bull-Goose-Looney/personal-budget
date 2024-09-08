package com.zach.budget.frontend.views;

import com.zach.budget.models.LineItem;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LineItemCell extends ListCell<LineItem> {

	public LineItemCell() {
	}

	@Override
	public void updateItem(LineItem item, boolean empty) {
		super.updateItem(item, empty);
		// create nodes
		if(item != null) {
//			setGraphic();
		}
	}

	private HBox createDescriptionBox() {
		return null;
	}

	//TODO onClick()
	private Button createEditButton() {
		return null;
	}

	private VBox createValuesBox() {
		return null;
	}


}
