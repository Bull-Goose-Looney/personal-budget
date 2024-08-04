
package com.zach.budget.entities;

import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;
import com.zach.budget.models.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "line_items")
public class LineItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_item_id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "description") 
    private String description;

    @Column(name = "planned_amount")
    private Float plannedAmount;

    @Column(name = "due_date")
    private DateEnums dueDate;

    @Column(name = "frequency")
    private FrequencyEnums frequencyOfDueDate;

    // Foreign key to category table.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    public LineItemEntity() {
       // Jakarta empty constructor 
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DateEnums getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateEnums dueDate) {
        this.dueDate = dueDate;
    }

    public void setFrequencyOfDueDate(FrequencyEnums frequencyOfDueDate) {
        this.frequencyOfDueDate = frequencyOfDueDate;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
