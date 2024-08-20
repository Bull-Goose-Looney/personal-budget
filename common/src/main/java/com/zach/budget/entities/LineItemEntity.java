package com.zach.budget.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;
import com.zach.budget.models.LineItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Column(name = "actual_amount")
    private Float actualAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "due_date")
    private DateEnums dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private FrequencyEnums frequencyOfDueDate;

    // Foreign key to category table.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private LineItemEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItemEntity> children = new ArrayList<>();

    public LineItemEntity() {
       // Jakarta empty constructor 
    }

    public LineItemEntity(LineItem lineItem) {
        this.name = lineItem.getName();
        this.description = lineItem.getDescription();
        this.plannedAmount = lineItem.getPlannedAmount();
        this.actualAmount = lineItem.getActualAmount();
        this.dueDate = lineItem.getDueDate().get();
        this.frequencyOfDueDate = lineItem.getFrequencyOfDueDate();
        this.category = new CategoryEntity(lineItem.getCategory());
        
        try {
            List<LineItem> models = lineItem.getChildren().get();
            List<LineItemEntity> childList = new ArrayList<>();
            for(LineItem model : models) {
                childList.add(new LineItemEntity(model));
            }
            this.children = childList;
        } catch (NoSuchElementException e) {
            this.children = new ArrayList<>();
        }
    }

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

    public Float getPlannedAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(Float plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public Float getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Float actualAmount) {
        this.actualAmount = actualAmount;
    }

    public FrequencyEnums getFrequencyOfDueDate() {
        return frequencyOfDueDate;
    }

    public void setFrequencyOfDueDate(FrequencyEnums frequencyOfDueDate) {
        this.frequencyOfDueDate = frequencyOfDueDate;
    }

    public DateEnums getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateEnums dueDate) {
        this.dueDate = dueDate;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LineItemEntity getParent() {
        return parent;
    }

    public void setParent(LineItemEntity parent) {
        this.parent = parent;
    }

    public List<LineItemEntity> getChildren() {
        return children; 
    }

    public void setChildren(List<LineItemEntity> children) {
        this.children = children;
    }

    public void addChild(LineItemEntity child) {
        this.children.add(child);
    }

}
