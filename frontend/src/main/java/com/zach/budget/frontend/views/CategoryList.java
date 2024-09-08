package com.zach.budget.frontend.views;

import com.zach.budget.frontend.controllers.CategoryController;
import com.zach.budget.models.Category;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;


/**
 * A ListView of Category Cells
 */
public class CategoryList {

	CategoryController categoryController;

	public CategoryList() {
		categoryController = new CategoryController();
	}

	public void getCategoryList() {
		ListView<Category> categoryListView = new ListView<>();
		categoryListView.setCellFactory(clv -> createCategoryCell());

		ObservableList<Category> categories = categoryController.loadCategories();

		categoryListView.setItems(categories);
	}

	private ListCell<Category> createCategoryCell() {
		return new ListCell<>() {
			@Override
			public void updateItem(Category category, boolean isEmpty) {
				super.updateItem(category, isEmpty);
				if(!isEmpty && (category != null)) {

				} else {

				}
			}
		};
	}

}
