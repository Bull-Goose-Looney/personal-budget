package com.zach.budget.models;

import java.time.LocalDateTime;

public class Transaction {

    private String description;
    private Float amount;
    LocalDateTime date;
    Account account;

    public Transaction(
          String description,
          Float amount, 
          LocalDateTime date,
          Account account) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Float getAmount() { return amount; }
    public void setAmount(Float amount) { this.amount = amount; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date;}

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
