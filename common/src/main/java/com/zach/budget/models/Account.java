package com.zach.budget.models;

import com.zach.budget.enums.AccountTypeEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String description;

	@Enumerated(EnumType.STRING)
	@Column
	private AccountTypeEnums type;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineItem> lineItems;

	public Account() {
	}

	public Account(String description, AccountTypeEnums type) {
		this.description = description;
		this.type = type;
		this.lineItems = new ArrayList<>();
	}
}
