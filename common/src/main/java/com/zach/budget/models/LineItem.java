package com.zach.budget.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zach.budget.enums.FrequencyEnums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String description;

    @Column(name = "planned_amount")
    private Double plannedAmount;

    @Column(name = "next_due")
    private LocalDateTime nextDue;

    @Column(name = "auto_pay")
    private boolean isAutoPay;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private FrequencyEnums frequency;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public LineItem() {}

    public LineItem(String description, Double plannedAmount, LocalDateTime nextDue,  FrequencyEnums frequency, boolean isAutoPay, Account account, Category category) {
        this.description = description;
        this.plannedAmount = plannedAmount;
        this.nextDue = nextDue;
        this.isAutoPay = isAutoPay;
        this.frequency = frequency;
        this.account = account;
        this.category = category;
    }

}
