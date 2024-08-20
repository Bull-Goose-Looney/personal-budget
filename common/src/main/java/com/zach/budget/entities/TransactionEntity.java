package com.zach.budget.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class TransactionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "transaction_date")
    LocalDateTime date;
    
    @ManyToOne
    @JoinColumn(name = "account_number")
    AccountEntity account;

    public TransactionEntity() {
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Float getAmount() { return amount; }
    public void setAmount(Float amount) { this.amount = amount; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date;}

    public AccountEntity getAccount() { return account; }
    public void setAccount(AccountEntity account) { this.account = account; }
}
