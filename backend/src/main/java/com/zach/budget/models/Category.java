package com.zach.budget.models;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private String description;
    private List<LineItem> lineItems;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.lineItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}
