package com.zach.budget.frontend.views;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class CategoryList extends ListView<CategoryCell> {

	ObservableList<CategoryCell> categoryCells;

	public CategoryList(ObservableList<CategoryCell> categoryCells) {
		this.categoryCells = categoryCells;
	}

}
