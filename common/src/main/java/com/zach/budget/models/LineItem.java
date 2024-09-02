package com.zach.budget.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "planned_amount")
    private Double plannedAmount;

    @Column(name = "actual_amount")
    private Double actualAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "due_date")
    private DateEnums date;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private FrequencyEnums frequency;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public LineItem() {}

    public LineItem(String name,  Double plannedAmount, Double actualAmount, DateEnums date, FrequencyEnums frequency) {
        this.name = name;
        this.plannedAmount = plannedAmount;
        this.actualAmount = actualAmount;
        this.date = date;
        this.frequency = frequency;
    }

}
