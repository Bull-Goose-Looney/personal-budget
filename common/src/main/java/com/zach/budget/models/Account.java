package com.zach.budget.models;

import com.zach.budget.enums.AccountTypeEnums;

public class Account {

    private Long accountNumber;
    private String accountName;
    private AccountTypeEnums accountType;

    public Account(Long accountNumber, String accountName, AccountTypeEnums accountType) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
    public String getName() { return accountName; }
    public void setName(String accountName) { this.accountName = accountName; }
    public AccountTypeEnums getAccountType() { return accountType; }

}
