package com.zach.budget.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Category {

	private String name;
	private List<LineItem> lineItems;

	public Category(String name){
		this.name = name;
		this.lineItems = new ArrayList<>();
	}

	public void addLineItem(LineItem lineItem) {
		this.lineItems.add(lineItem);
	}
}
