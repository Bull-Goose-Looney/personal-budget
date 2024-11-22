package com.zach.budget.models;

import com.zach.budget.enums.FrequencyEnums;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class LineItem {
	private String name;
	private Double plannedAmount;
	private LocalDate nextDue;
	private boolean isAutoPay;
	private FrequencyEnums frequency;
	private Account account;
	private Category category;

	public LineItem(String name, Double plannedAmount, LocalDate nextDue, 
			FrequencyEnums frequency, boolean isAutoPay, Account account, Category category) {
		this.name = name;
		this.plannedAmount = plannedAmount;
		this.nextDue = nextDue;
		this.isAutoPay = isAutoPay;
		this.frequency = frequency;
		this.account = account;
		this.category = category;
	}

	@Override
	public String toString() {
		return(
				this.name +
				this.plannedAmount.toString() +
				this.nextDue.toString() +
				this.isAutoPay +
				this.frequency +
				this.category.getName()
		);
	}
}
