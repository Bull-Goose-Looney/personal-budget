package com.zach.budget.entities;

import com.zach.budget.enums.AccountTypeEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class AccountEntity {

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
	private List<LineItemEntity> lineItems;

	public AccountEntity() {
	}

	public AccountEntity(String description, AccountTypeEnums type) {
		this.description = description;
		this.type = type;
		this.lineItems = new ArrayList<>();
	}
}
