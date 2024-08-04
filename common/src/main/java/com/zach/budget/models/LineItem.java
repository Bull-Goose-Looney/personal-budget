package com.zach.budget.models;

import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;

import java.util.Optional;

public abstract class LineItem {

    private String name;
    private String description;
    private Float plannedAmount;
    private Optional<DateEnums> dueDate;
    private FrequencyEnums frequencyOfDueDate;
    private Category category;

    public LineItem(
          String name,
          String description,
          Float plannedAmount, 
          Optional<DateEnums> dueDate, 
          FrequencyEnums frequencyOfDueDate, 
          Category category) {
        this.name = name;
        this.description = description;
        this.plannedAmount = plannedAmount;
        this.dueDate = dueDate;
        this.frequencyOfDueDate = frequencyOfDueDate;
        this.category = category;
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

    public Float getAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(Float plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public void increasePlannedAmount(Float plannedAmount) {
        this.plannedAmount += plannedAmount;
    }

    public void decreasePlannedAmount(Float plannedAmount) {
        this.plannedAmount -= plannedAmount;
    }

    public FrequencyEnums getFrequencyOfDueDate() {
        return frequencyOfDueDate;
    }

    public Optional<DateEnums> getDueDate() {
        return dueDate;
    }

    public void setDueDate(Optional<DateEnums> dueDate) {
        this.dueDate = dueDate;
    }

    public void setFrequencyOfDueDate(FrequencyEnums frequencyOfDueDate) {
        this.frequencyOfDueDate = frequencyOfDueDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
