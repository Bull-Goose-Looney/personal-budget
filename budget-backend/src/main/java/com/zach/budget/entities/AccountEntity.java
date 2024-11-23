package com.zach.budget.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zach.budget.enums.AccountTypeEnums;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Enumerated(EnumType.STRING)
	@Column
	private AccountTypeEnums type;

	@JsonIgnore
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineItemEntity> lineItems;

	public AccountEntity() {
	}

	public AccountEntity(String name, AccountTypeEnums type) {
		this.name = name;
		this.type = type;
		this.lineItems = new ArrayList<>();
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

	public AccountTypeEnums getType() {
		return type;
	}

	public void setType(AccountTypeEnums type) {
		this.type = type;
	}

	public List<LineItemEntity> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemEntity> lineItems) {
		this.lineItems = lineItems;
	}

}
