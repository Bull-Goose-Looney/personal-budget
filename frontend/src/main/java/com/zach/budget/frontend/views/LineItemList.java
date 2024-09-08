package com.zach.budget.frontend.views;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class LineItemList extends ListView<LineItemCell> {
	ObservableList<LineItemCell> lineItems;

	public LineItemList(ObservableList<LineItemCell> lineItemCells) {
		this.lineItems = lineItemCells;
	}

}
