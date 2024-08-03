package com.zach.budget.models;

import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;

public class Debt extends Expense {

    private Float interestRate;

    public Debt(Float amount, FrequencyEnums frequency, DateEnums dueDate, Float interestRate, String description, PaymentMethod paymentMethod) {

        super(amount, frequency, dueDate, description, paymentMethod);
        this.interestRate = interestRate;
    }

    public Float getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

}
