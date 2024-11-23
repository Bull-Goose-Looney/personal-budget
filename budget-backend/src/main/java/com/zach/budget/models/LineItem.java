package com.zach.budget.models;

import java.time.LocalDate;

import com.zach.budget.enums.FrequencyEnums;

public class LineItem {

	private Long id;
	private String name;
	private Double plannedAmount;
	private LocalDate nextDue;
	private Boolean isAutoPay;
	private FrequencyEnums frequency;
	private Account account;
	private Category category;

	public LineItem(String name, Double plannedAmount, LocalDate nextDue, 
			FrequencyEnums frequency, boolean isAutoPay, Account account, Category category) {
		this.id = null;
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

	public Double getPlannedAmount() {
		return plannedAmount;
	}

	public void setPlannedAmount(double plannedAmount) {
		this.plannedAmount = plannedAmount;
	}

	public LocalDate nextDue() {
		return nextDue;
	}

	public void setNextDue(LocalDate nextDue) {
		this.nextDue = nextDue;
	}

	public Boolean getIsAutoPay() {
		return isAutoPay;
	}

	public void setIsAutoPay(Boolean isAutoPay) {
		this.isAutoPay = isAutoPay;
	}

	public FrequencyEnums getFrequency() {
		return frequency;
	}

	public void setFrequency(FrequencyEnums frequency) {
		this.frequency = frequency;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
