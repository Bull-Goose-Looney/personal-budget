package com.zach.budget.models;

public class Category {

    private String name;
    private String description;
    private Integer priority;

    public Category() {
        // default for jackson
    }

    public Category(String name, String description, Integer priority) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
