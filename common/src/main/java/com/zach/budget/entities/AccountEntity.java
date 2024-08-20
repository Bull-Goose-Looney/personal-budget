package com.zach.budget.entities;

import java.util.List;

import com.zach.budget.enums.AccountTypeEnums;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountTypeEnums accountType;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionEntity> transactions;

    public AccountEntity() {
    }

    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
    public String getName() { return accountName; }
    public void setName(String accountName) { this.accountName = accountName; }
    public AccountTypeEnums getAccountType() { return accountType; }

}
