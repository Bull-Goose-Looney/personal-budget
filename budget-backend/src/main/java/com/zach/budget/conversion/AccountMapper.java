package com.zach.budget.conversion;


import org.springframework.stereotype.Component;

import com.zach.budget.entities.AccountEntity;
import com.zach.budget.models.Account;

@Component
public class AccountMapper {

    public Account toModel(AccountEntity entity) {
        Account model = new Account();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setType(entity.getType());
        return model;
    }

    public AccountEntity toEntity(Account model) {
        AccountEntity entity = new AccountEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setType(model.getType());
        return entity;
    } 
}


