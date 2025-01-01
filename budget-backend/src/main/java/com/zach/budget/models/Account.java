package com.zach.budget.models;

import com.zach.budget.enums.AccountTypeEnums;

public class Account {

	private Long id;
	private String name;
	private AccountTypeEnums type;

	public Account() {
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

}
