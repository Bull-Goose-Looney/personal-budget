package com.zach.budget.models;

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
    @Column(name = "line_item_id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "planned_amount")
    private Float plannedAmount;

    @Column(name = "actual_amount")
    private Float actualAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "due_date")
    private DateEnums date;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private FrequencyEnums frequency;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public LineItem() {}

    public LineItem(String name,  Float plannedAmount, Float actualAmount, DateEnums date, FrequencyEnums frequency) {
        this.name = name;
        this.plannedAmount = plannedAmount;
        this.actualAmount = actualAmount;
        this.date = date;
        this.frequency = frequency;
    }

}
