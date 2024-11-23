package com.zach.budget.entities;

import java.time.LocalDate;

import com.zach.budget.enums.FrequencyEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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
		this.frequency = frequency;
		this.isAutoPay = isAutoPay;
		this.account = account;
		this.category = category;
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

	public LocalDate getNextDue() {
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

	public AccountEntity getAccount() {
		return this.account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
