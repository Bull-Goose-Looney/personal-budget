package com.zach.budget.conversion;

import org.mapstruct.Mapper;

import com.zach.budget.entities.AccountEntity;
import com.zach.budget.models.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toModel(AccountEntity entity);
    AccountEntity toEntity(Account category); 
}
