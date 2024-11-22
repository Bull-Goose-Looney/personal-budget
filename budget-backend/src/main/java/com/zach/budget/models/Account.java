package com.zach.budget.models;

import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.enums.AccountTypeEnums;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Account {
		private Long id;
		private String name;
		private AccountTypeEnums type;
		private List<LineItemEntity> lineItems;

		public Account() {}

}
