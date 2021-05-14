package com.ceiba.coffee.model.valueobject;

public class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static Money createUSD(double amount){
        return new Money(amount, Currency.USD);
    }

    public Money add(double amount) {
        amount += this.amount;
        return new Money(amount, this.currency);
    }

    public Money subtract(double amount) {
        amount = this.amount - amount;
        return new Money(amount, this.currency);
    }

}
