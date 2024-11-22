package com.zach.budget.entities;

import com.zach.budget.enums.FrequencyEnums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class LineItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "planned_amount")
	private Double plannedAmount;

	@Column(name = "next_due")
	private LocalDate nextDue;

	@Column(name = "auto_pay")
	private boolean isAutoPay;

	@Enumerated(EnumType.STRING)
	@Column(name = "frequency")
	private FrequencyEnums frequency;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountEntity account;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	public LineItemEntity() {
	}

	public LineItemEntity(String name, Double plannedAmount, LocalDate nextDue, FrequencyEnums frequency, boolean isAutoPay, AccountEntity account, CategoryEntity category) {
		this.name = name;
		this.plannedAmount = plannedAmount;
		this.nextDue = nextDue;
		this.isAutoPay = isAutoPay;
		this.frequency = frequency;
		this.account = account;
		this.category = category;
	}

}
