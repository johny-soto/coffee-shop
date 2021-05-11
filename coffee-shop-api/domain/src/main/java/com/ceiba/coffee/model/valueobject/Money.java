package com.ceiba.coffee.model.valueobject;

public class Money {
    private final int amount;
    private final Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static Money createUSD(int amount){
        return new Money(amount, new Currency("USD"));
    }
}
